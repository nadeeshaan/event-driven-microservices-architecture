package com.acme.inventory.events.products;

public class StockAddedEvent {
  private final String productId;
  private final Double stock;

  public StockAddedEvent(String productId, Double stock) {
    this.productId = productId;
    this.stock = stock;
  }

  public String getProductId() {
    return productId;
  }

  public Double getStock() {
    return stock;
  }
}
