package com.turkcell.library_cqrs.core.logging;

import org.springframework.stereotype.Component;

import com.turkcell.library_cqrs.core.mediator.pipeline.PipelineBehavior;
import com.turkcell.library_cqrs.core.mediator.pipeline.RequestHandlerDelegate;

@Component
public class PerformanceBehavior implements PipelineBehavior {

    @Override
    public <R> R handle(
            Object request,
            RequestHandlerDelegate<R> next) {

        long start = System.currentTimeMillis();

        R response = next.invoke();

        long end = System.currentTimeMillis();

        long duration = end - start;

        if (duration > 3000) {

            System.out.println(
                    "PERFORMANCE WARNING -> "
                    + request.getClass().getSimpleName()
                    + " took "
                    + duration
                    + " ms"
            );
        }

        return response;
    }
}