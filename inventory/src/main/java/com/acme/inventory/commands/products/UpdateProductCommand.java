package com.acme.inventory.commands.products;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class UpdateProductCommand {
  @TargetAggregateIdentifier protected String id;
  protected Double unitPrice;
  protected Double discount;
  protected String description;

  public UpdateProductCommand(
      String productId, Double unitPrice, Double discount, String description) {
    this.id = productId;
    this.description = description;
    this.unitPrice = unitPrice;
    this.discount = discount;
  }

  public String getId() {
    return id;
  }

  public Double getUnitPrice() {
    return unitPrice;
  }

  public Double getDiscount() {
    return discount;
  }

  public String getDescription() {
    return description;
  }
}
