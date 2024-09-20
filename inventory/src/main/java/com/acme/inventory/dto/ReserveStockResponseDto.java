package com.acme.inventory.dto;

public class ReserveStockResponseDto {
  private String id;

  public ReserveStockResponseDto(String id) {
    this.id = id;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }
}
