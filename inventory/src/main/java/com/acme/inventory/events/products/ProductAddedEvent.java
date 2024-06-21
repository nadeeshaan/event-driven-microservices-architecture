package com.acme.inventory.events.products;

import com.acme.inventory.aggregates.products.ProductKind;

public class ProductAddedEvent {
  private final String productId;
  private final ProductKind productKind;
  private final String name;
  private final String description;
  private final Double unitPrice;

  public ProductAddedEvent(
      String productId,
      ProductKind productKind,
      String name,
      String description,
      Double unitPrice) {
    this.productId = productId;
    this.productKind = productKind;
    this.name = name;
    this.description = description;
    this.unitPrice = unitPrice;
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
}
