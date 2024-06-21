package com.acme.inventory.dto;

public class ProductStockDto {
  private Double quantity;

//  public ProductStockDto(Double quantity) {
//    this.quantity = quantity;
//  }

  public Double getQuantity() {
    return quantity;
  }

  public void setQuantity(Double quantity) {
    this.quantity = quantity;
  }
}
