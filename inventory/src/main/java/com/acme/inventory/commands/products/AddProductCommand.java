package com.acme.inventory.commands.products;

import com.acme.inventory.aggregates.products.ProductKind;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class AddProductCommand {

  @TargetAggregateIdentifier
  private String id;

  private ProductKind productKind;
  private String name;
  private String description;
  private Double price;

  public AddProductCommand(String productId, ProductKind productKind, String name, String description, Double price) {
    this.id = productId;
    this.productKind = productKind;
    this.name = name;
    this.description = description;
    this.price = price;
  }

  public ProductKind getProductKind() {
    return productKind;
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public Double getPrice() {
    return price;
  }

  public String getId() {
    return id;
  }
}
