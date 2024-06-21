package com.acme.inventory.commands.products;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class ProcessStockCommand {
  @TargetAggregateIdentifier protected String id;
  protected Double stock;

  public ProcessStockCommand(String productId, Double stock) {
    this.id = productId;
    this.stock = stock;
  }

  public Double getStock() {
    return stock;
  }

  public String getId() {
    return id;
  }
}
