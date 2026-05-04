package com.turkcell.library_cqrs.application.features.category.command.create;

// Command-Query -> DTO

import java.util.UUID;

import com.turkcell.library_cqrs.core.mediator.cqrs.Command;

public record CreateCategoryCommand(String name, String description) implements Command<UUID> {}
