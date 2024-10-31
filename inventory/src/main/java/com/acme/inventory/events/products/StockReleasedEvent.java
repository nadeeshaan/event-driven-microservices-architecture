package com.acme.inventory.events.products;

public class StockReleasedEvent {
  private final String productId;
  private final Double stock;

  public StockReleasedEvent(String productId, Double stock) {
    this.productId = productId;
    this.stock = stock;
  }

  public Double getStock() {
    return stock;
  }

  public String getProductId() {
    return productId;
  }
}
