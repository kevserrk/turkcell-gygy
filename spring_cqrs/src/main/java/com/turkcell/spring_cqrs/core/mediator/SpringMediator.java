package com.turkcell.spring_cqrs.core.mediator;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.core.ResolvableType;
import org.springframework.stereotype.Component;

import com.turkcell.spring_cqrs.core.mediator.cqrs.Command;
import com.turkcell.spring_cqrs.core.mediator.cqrs.CommandHandler;
import com.turkcell.spring_cqrs.core.mediator.cqrs.Query;
import com.turkcell.spring_cqrs.core.mediator.cqrs.QueryHandler;
import com.turkcell.spring_cqrs.core.mediator.pipeline.PipelineBehavior;
import com.turkcell.spring_cqrs.core.mediator.pipeline.RequestHandlerDelegate;

@Component
public class SpringMediator implements Mediator {

    private final ApplicationContext context;
    private final List<PipelineBehavior> pipelineBehaviors;

    public SpringMediator(
            ApplicationContext context,
            List<PipelineBehavior> pipelineBehaviors) {

        this.context = context;
        this.pipelineBehaviors = pipelineBehaviors;
    }

    @Override
    public <R> R send(Command<R> command) {

        var handler =
                (CommandHandler<Command<R>, R>)
                        resolveHandler(
                                command.getClass(),
                                CommandHandler.class);

        RequestHandlerDelegate<R> delegate =
                () -> handler.handle(command);

        return executePipeline(command, delegate);
    }

    @Override
    public <R> R send(Query<R> query) {

        var handler =
                (QueryHandler<Query<R>, R>)
                        resolveHandler(
                                query.getClass(),
                                QueryHandler.class);

        RequestHandlerDelegate<R> delegate =
                () -> handler.handle(query);

        return executePipeline(query, delegate);
    }

    private <R> R executePipeline(
            Object request,
            RequestHandlerDelegate<R> delegate) {

        RequestHandlerDelegate<R> current = delegate;

        for (int i = pipelineBehaviors.size() - 1; i >= 0; i--) {

            PipelineBehavior behavior =
                    pipelineBehaviors.get(i);

            RequestHandlerDelegate<R> next = current;

            current = () ->
                    behavior.handle(request, next);
        }

        return current.invoke();
    }

    
    private Object resolveHandler(
            Class<?> requestType,
            Class<?> handlerInterface) {

        String[] beanNames =
                context.getBeanNamesForType(handlerInterface);

        for (String beanName : beanNames) {

            Class<?> beanClass =
                    context.getType(beanName);

            if (beanClass == null)
                continue;

            ResolvableType[] interfaces =
                    ResolvableType
                            .forClass(beanClass)
                            .getInterfaces();

            for (ResolvableType iface : interfaces) {

                if (iface.getRawClass() != null
                        && handlerInterface.isAssignableFrom(
                                iface.getRawClass())) {

                    Class<?> firstGeneric =
                            iface.getGeneric(0).resolve();

                    if (firstGeneric != null
                            && firstGeneric.equals(requestType))

                        return context.getBean(beanName);
                }
            }
        }

        throw new IllegalStateException(
                "Handler bulunamadı: "
                        + requestType.getSimpleName());
    }
}