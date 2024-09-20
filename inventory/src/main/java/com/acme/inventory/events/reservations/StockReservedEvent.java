package com.acme.inventory.events.reservations;

public class StockReservedEvent {
  private String reservationId;
  private String productId;
  private String orderId;
  private String date;
  private Double quota;

  public StockReservedEvent(
      String reservationId, String productId, String orderId, String date, Double quota) {
    this.reservationId = reservationId;
    this.productId = productId;
    this.orderId = orderId;
    this.quota = quota;
    this.date = date;
  }

  public String getReservationId() {
    return reservationId;
  }

  public void setReservationId(String reservationId) {
    this.reservationId = reservationId;
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

  public String getOrderId() {
    return orderId;
  }

  public void setOrderId(String orderId) {
    this.orderId = orderId;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }
}
