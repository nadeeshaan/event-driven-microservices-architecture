package com.acme.inventory.events.reservations;

public class ReservedStockProcessedEvent {
  private String reservationId;
  private String date;
  private String productId;
  private Double quota;

  public ReservedStockProcessedEvent(
      String reservationId, String date, String productId, Double quota) {
    this.reservationId = reservationId;
    this.date = date;
    this.productId = productId;
    this.quota = quota;
  }

  public String getReservationId() {
    return reservationId;
  }

  public void setReservationId(String reservationId) {
    this.reservationId = reservationId;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public String getProductId() {
    return productId;
  }

  public void setProductId(String productId) {
    this.productId = productId;
  }

  public Double getQuota() {
    return quota;
  }

  public void setQuota(Double quota) {
    this.quota = quota;
  }
}
