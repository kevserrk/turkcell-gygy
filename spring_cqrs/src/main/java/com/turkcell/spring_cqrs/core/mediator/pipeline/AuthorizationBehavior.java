package com.turkcell.spring_cqrs.core.mediator.pipeline;

import java.util.List;

import org.springframework.stereotype.Component;

import com.turkcell.spring_cqrs.core.security.authorization.AuthorizableRequest;
import com.turkcell.spring_cqrs.core.security.context.UserContext;
import com.turkcell.spring_cqrs.core.security.exception.AuthenticatedException;
import com.turkcell.spring_cqrs.core.security.exception.AuthorizationException;

@Component
public class AuthorizationBehavior implements PipelineBehavior {

    private final UserContext userContext;

    public AuthorizationBehavior(UserContext userContext) {
        this.userContext = userContext;
    }

    @Override
    public <R> R handle(Object request, RequestHandlerDelegate<R> next) {

        if(request instanceof AuthorizableRequest authRequest)
        {
            if(!userContext.isAuthenticated())
            {
                throw new AuthenticatedException(
                        "User is not authenticated");
            }

            List<String> requiredRoles =
                    authRequest.requiredRoles();

            if(requiredRoles != null &&
                    !requiredRoles.isEmpty())
            {
                boolean hasRole =
                        requiredRoles.stream()
                                .anyMatch(role ->
                                        userContext.getRoles()
                                                .contains(role));

                if(!hasRole)
                {
                    throw new AuthorizationException(
                            "Access denied");
                }
            }
        }

        return next.invoke();
    }
}
