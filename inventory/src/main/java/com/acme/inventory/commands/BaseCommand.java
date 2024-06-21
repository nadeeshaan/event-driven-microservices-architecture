package com.acme.inventory.commands;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class BaseCommand {
  @TargetAggregateIdentifier protected final String id;

  public BaseCommand(String id) {
    this.id = id;
  }

  public String getId() {
    return id;
  }
}
