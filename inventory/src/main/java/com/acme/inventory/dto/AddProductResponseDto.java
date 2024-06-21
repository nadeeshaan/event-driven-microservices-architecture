package com.acme.inventory.dto;

public class AddProductResponseDto {
  private String productId;

  public AddProductResponseDto(String productId) {
    this.productId = productId;
  }

  public String getProductId() {
    return productId;
  }

  public void setProductId(String productId) {
    this.productId = productId;
  }
}
