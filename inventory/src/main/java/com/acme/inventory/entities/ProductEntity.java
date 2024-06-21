package com.acme.inventory.entities;

import com.acme.inventory.aggregates.products.ProductKind;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ProductEntity {
  @Id private String id;

  private String name;

  private double unitPrice;

  private Double stock;

  private ProductKind kind;

  public ProductEntity() {}

  public ProductEntity(String id, String name, double unitPrice, Double stock, ProductKind kind) {
    this.id = id;
    this.name = name;
    this.unitPrice = unitPrice;
    this.stock = stock;
    this.kind = kind;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getUnitPrice() {
    return unitPrice;
  }

  public void setUnitPrice(double unitPrice) {
    this.unitPrice = unitPrice;
  }

  public Double getStock() {
    return stock;
  }

  public void setStock(Double stock) {
    this.stock = stock;
  }

  public ProductKind getKind() {
    return kind;
  }

  public void setKind(ProductKind kind) {
    this.kind = kind;
  }
}
