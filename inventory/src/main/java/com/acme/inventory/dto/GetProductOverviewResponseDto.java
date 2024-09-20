package com.acme.inventory.dto;

public class GetProductOverviewResponseDto {
  private final String productId;
  private final Double unitPrice;

  private final String description;

  public GetProductOverviewResponseDto(String productId, String description, Double unitPrice) {
    this.productId = productId;
    this.description = description;
    this.unitPrice = unitPrice;
  }

  public String getProductId() {
    return productId;
  }

  public Double getUnitPrice() {
    return unitPrice;
  }

  public String getDescription() {
    return description;
  }
}
