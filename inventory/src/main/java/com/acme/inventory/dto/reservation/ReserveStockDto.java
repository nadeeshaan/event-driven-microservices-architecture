package com.acme.inventory.dto.reservation;

public class ReserveStockDto {
  private String productId;

  private Double quota;
  private String orderId;
  private String date;

  public ReserveStockDto(String productId, String orderId, String date, Double quota) {
    this.productId = productId;
    this.orderId = orderId;
    this.date = date;
    this.quota = quota;
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
