package com.acme.inventory.commands.products;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class AddStockCommand {

  @TargetAggregateIdentifier
  private String id;

  private final Double stock;

  public AddStockCommand(String productId, Double stock) {
    this.id = productId;
    this.stock = stock;
  }

  public Double getStock() {
    return this.stock;
  }

  public String getId() {
    return id;
  }
}
