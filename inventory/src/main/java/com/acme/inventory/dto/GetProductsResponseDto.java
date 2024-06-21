package com.acme.inventory.dto;

import com.acme.inventory.aggregates.products.ProductKind;

public class GetProductsResponseDto {
  private final String productId;
  private final ProductKind kind;
  private final Double unitPrice;

  public GetProductsResponseDto(String productId, ProductKind kind, Double unitPrice) {
    this.productId = productId;
    this.kind = kind;
    this.unitPrice = unitPrice;
  }

  public String getProductId() {
    return productId;
  }

  public ProductKind getKind() {
    return kind;
  }

  public Double getUnitPrice() {
    return unitPrice;
  }
}
