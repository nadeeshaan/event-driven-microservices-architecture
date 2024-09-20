package com.acme.inventory.events.products;

import com.acme.inventory.aggregates.products.ProductKind;

public class ProductAddedEvent {
  private final String productId;
  private final ProductKind productKind;
  private final String name;
  private final String description;
  private final Double unitPrice;
  private final Double discount;
  private final String author;

  public ProductAddedEvent(
      String productId,
      ProductKind productKind,
      String name,
      String author,
      String description,
      Double unitPrice,
      Double discount) {
    this.productId = productId;
    this.productKind = productKind;
    this.name = name;
    this.author = author;
    this.description = description;
    this.unitPrice = unitPrice;
    this.discount = discount;
  }

  public String getProductId() {
    return productId;
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

  public Double getUnitPrice() {
    return unitPrice;
  }

  public Double getDiscount() {
    return discount;
  }

  public String getAuthor() {
    return author;
  }
}
