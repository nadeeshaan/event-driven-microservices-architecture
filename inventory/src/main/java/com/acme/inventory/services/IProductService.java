package com.acme.inventory.services;

import com.acme.inventory.dto.ProductStockDto;
import com.acme.inventory.dto.AddProductDto;
import com.acme.inventory.dto.AddProductResponseDto;
import com.acme.inventory.dto.GetProductsResponseDto;

import java.util.concurrent.CompletableFuture;

public interface IProductService {
  AddProductResponseDto addProduct(AddProductDto command);

  void addStock(ProductStockDto stockDto, String productId);

  void processStock(ProductStockDto stockDto, String productId);

  CompletableFuture<GetProductsResponseDto> getProduct(String productId);
}
