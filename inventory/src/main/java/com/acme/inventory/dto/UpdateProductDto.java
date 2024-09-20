package com.acme.inventory.dto;

public class UpdateProductDto {
  private final String description;
  private final Double price;
  private final Double discount;

  public UpdateProductDto(String description, Double price, Double discount) {
    this.description = description;
    this.price = price;
    this.discount = discount;
  }

  public String getDescription() {
    return description;
  }

  public Double getPrice() {
    return price;
  }

  public Double getDiscount() {
    return discount;
  }
}
