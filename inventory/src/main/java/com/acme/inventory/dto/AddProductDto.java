package com.acme.inventory.dto;

import com.acme.inventory.aggregates.products.ProductKind;

public class AddProductDto {
  private final ProductKind productKind;
  private final String name;
  private final String description;
  private final Double price;

  public AddProductDto(ProductKind productKind, String name, String description, Double price) {
    this.productKind = productKind;
    this.name = name;
    this.description = description;
    this.price = price;
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

  public Double getPrice() {
    return price;
  }
}
