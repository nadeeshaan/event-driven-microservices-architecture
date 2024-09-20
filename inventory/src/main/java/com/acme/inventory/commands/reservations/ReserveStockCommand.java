package com.acme.inventory.commands.reservations;

import com.acme.inventory.commands.BaseCommand;

public class ReserveStockCommand extends BaseCommand {
  private String productId;
  private String orderId;
  private String date;
  private Double quota;

  public ReserveStockCommand(String id, String productId, String orderId, String date, Double quota) {
    super(id);
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
