package com.acme.inventory.queries;

public class GetProductQuery {
  private final String productId;

  public GetProductQuery(String productId) {
    this.productId = productId;
  }

  public String getProductId() {
    return productId;
  }
}
