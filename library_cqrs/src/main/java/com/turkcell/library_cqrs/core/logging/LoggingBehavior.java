package com.turkcell.library_cqrs.core.logging;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.turkcell.library_cqrs.core.mediator.pipeline.PipelineBehavior;
import com.turkcell.library_cqrs.core.mediator.pipeline.RequestHandlerDelegate;

@Component
public class LoggingBehavior implements PipelineBehavior {

    private final ObjectMapper objectMapper;

    public LoggingBehavior(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public <R> R handle(
            Object request,
            RequestHandlerDelegate<R> next) {

        try {

            System.out.println("REQUEST:");
            System.out.println(
                    objectMapper.writeValueAsString(request)
            );

            R response = next.invoke();

            System.out.println("RESPONSE:");
            System.out.println(
                    objectMapper.writeValueAsString(response)
            );

            return response;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}