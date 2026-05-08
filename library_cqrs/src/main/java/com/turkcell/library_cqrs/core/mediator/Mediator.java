package com.turkcell.library_cqrs.core.mediator;

public interface Mediator {

    <R> R send(Object request);
}