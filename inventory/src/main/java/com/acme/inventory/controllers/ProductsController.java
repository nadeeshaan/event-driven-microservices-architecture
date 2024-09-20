package com.acme.inventory.controllers;

import com.acme.inventory.dto.*;
import com.acme.inventory.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api")
public class ProductsController {
  private final IProductService productService;

  @Autowired
  public ProductsController(IProductService productService) {
    this.productService = productService;
  }

  @PostMapping(value = "/product")
  public CompletableFuture<AddProductResponseDto> addProduct(
      @RequestBody AddProductDto productDto) {
    return this.productService.addProduct(productDto);
  }

  @PostMapping("/product/{id}/stock/add")
  public ResponseEntity<Void> addStock(
      @RequestBody ProductStockDto stockDto, @PathVariable String id) {
    this.productService.addStock(stockDto, id);

    return ResponseEntity.accepted().build();
  }

  @PostMapping("/product/{id}/stock/process")
  public ResponseEntity<Void> processStock(
      @RequestBody ProductStockDto stockDto, @PathVariable String id) {
    this.productService.processStock(stockDto, id);

    return ResponseEntity.accepted().build();
  }

  @GetMapping("/product/{id}")
  public CompletableFuture<GetProductOverviewResponseDto> getProduct(@PathVariable String id) {
    return this.productService.getProduct(id);
  }

  @PatchMapping("/product/{id}")
  public ResponseEntity<Void> updateProduct(
      @PathVariable String id, @RequestBody UpdateProductDto updateProductDto) {
    this.productService.updateProduct(id, updateProductDto);

    return ResponseEntity.noContent().build();
  }
}
