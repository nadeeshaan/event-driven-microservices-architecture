package com.acme.inventory.events.products;

public class ProductDetailsUpdatedEvent {
  private final String productId;

  private final String description;

  private final Double unitPrice;

  private final Double discount;

  public ProductDetailsUpdatedEvent(
      String productId, String description, Double unitPrice, Double discount) {
    this.productId = productId;
    this.description = description;
    this.unitPrice = unitPrice;
    this.discount = discount;
  }

  public String getProductId() {
    return productId;
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
}
