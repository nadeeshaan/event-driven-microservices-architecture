package com.acme.inventory.commands.products;

import com.acme.inventory.aggregates.products.ProductKind;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class AddProductCommand {
  @TargetAggregateIdentifier private final String id;

  private final ProductKind productKind;
  private final String name;
  private final String description;
  private final Double price;
  private final Double discount;
  private String author;

  public AddProductCommand(
      String productId,
      ProductKind productKind,
      String name,
      String author,
      String description,
      Double price,
      Double discount) {
    this.id = productId;
    this.productKind = productKind;
    this.name = name;
    this.author = author;
    this.description = description;
    this.price = price;
    this.discount = discount;
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

  public Double getDiscount() {
    return discount;
  }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
