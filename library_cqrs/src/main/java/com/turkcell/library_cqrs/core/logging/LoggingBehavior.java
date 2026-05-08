package com.turkcell.library_cqrs.core.logging;

import org.springframework.stereotype.Component;

import com.turkcell.library_cqrs.core.mediator.pipeline.PipelineBehavior;
import com.turkcell.library_cqrs.core.mediator.pipeline.RequestHandlerDelegate;

@Component
public class LoggingBehavior implements PipelineBehavior {

    @Override
    public <R> R handle(
            Object request,
            RequestHandlerDelegate<R> next) {

        System.out.println("REQUEST:");
        System.out.println(request);

        R response = next.invoke();

        System.out.println("RESPONSE:");
        System.out.println(response);

        return response;
    }
}