package com.acme.inventory.services;

import com.acme.inventory.dto.AddProductDto;
import com.acme.inventory.dto.AddProductResponseDto;
import com.acme.inventory.dto.GetProductOverviewResponseDto;
import com.acme.inventory.dto.ProductStockDto;
import com.acme.inventory.dto.UpdateProductDto;

import java.util.concurrent.CompletableFuture;

public interface IProductService {
  CompletableFuture<AddProductResponseDto> addProduct(AddProductDto command);

  void addStock(ProductStockDto stockDto, String productId);

  void processStock(ProductStockDto stockDto, String productId);
  
  void releaseStock(ProductStockDto stockDto, String productId);

  CompletableFuture<GetProductOverviewResponseDto> getProduct(String productId);

  CompletableFuture<GetProductOverviewResponseDto> updateProduct(
      String id, UpdateProductDto updateProductDto);
}
