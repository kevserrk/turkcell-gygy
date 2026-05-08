package com.turkcell.library_cqrs.core.mediator;

import java.lang.reflect.Method;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.turkcell.library_cqrs.core.mediator.pipeline.PipelineBehavior;
import com.turkcell.library_cqrs.core.mediator.pipeline.RequestHandlerDelegate;

@Component
public class SpringMediator implements Mediator {

    private final ApplicationContext applicationContext;
    private final List<PipelineBehavior> pipelineBehaviors;

    public SpringMediator(
            ApplicationContext applicationContext,
            List<PipelineBehavior> pipelineBehaviors) {

        this.applicationContext = applicationContext;
        this.pipelineBehaviors = pipelineBehaviors;
    }

    @Override
    public <R> R send(Object request) {

        Object handler = findHandler(request);

        RequestHandlerDelegate<R> delegate =
                () -> invokeHandler(handler, request);

        for (PipelineBehavior behavior : pipelineBehaviors) {

            RequestHandlerDelegate<R> next = delegate;

            delegate = () -> behavior.handle(request, next);
        }

        return delegate.invoke();
    }

    private Object findHandler(Object request) {

        String handlerName =
                request.getClass().getSimpleName() + "Handler";

        return applicationContext.getBeansOfType(Object.class)
                .values()
                .stream()
                .filter(bean ->
                        bean.getClass()
                                .getSimpleName()
                                .equals(handlerName))
                .findFirst()
                .orElseThrow();
    }

    @SuppressWarnings("unchecked")
    private <R> R invokeHandler(Object handler, Object request) {

        try {

            Method method =
                    handler.getClass()
                            .getMethod("handle",
                                    request.getClass());

            return (R) method.invoke(handler, request);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}