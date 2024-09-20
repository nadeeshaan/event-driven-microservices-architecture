package com.acme.inventory.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ProductManagementOverviewEntity {
  @Id private String id;

  @Column(unique = true)
  private String productId;

  private String name;
  private Double unitPrice;
  private Double reservations;
  private String lastRestockDate;
  private String lastReservationDate;
  private String description;

  public ProductManagementOverviewEntity(
      String id,
      String productId,
      String name,
      String description,
      Double unitPrice,
      Double reservations,
      String lastRestockDate,
      String lastReservationDate) {
    this.id = id;
    this.productId = productId;
    this.name = name;
    this.description = description;
    this.unitPrice = unitPrice;
    this.reservations = reservations;
    this.lastRestockDate = lastRestockDate;
    this.lastReservationDate = lastReservationDate;
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

  public Double getReservations() {
    return reservations;
  }

  public void setReservations(Double reservations) {
    this.reservations = reservations;
  }

  public String getLastRestockDate() {
    return lastRestockDate;
  }

  public void setLastRestockDate(String lastRestockDate) {
    this.lastRestockDate = lastRestockDate;
  }

  public String getLastReservationDate() {
    return lastReservationDate;
  }

  public void setLastReservationDate(String lastReservationDate) {
    this.lastReservationDate = lastReservationDate;
  }

  public String getProductId() {
    return productId;
  }

  public void setProductId(String productId) {
    this.productId = productId;
  }

  public void setUnitPrice(Double unitPrice) {
    this.unitPrice = unitPrice;
  }

  public ProductManagementOverviewEntity() {}

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
