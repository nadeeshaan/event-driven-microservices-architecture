package com.acme.inventory.controllers;

import com.acme.inventory.dto.ProductStockDto;
import com.acme.inventory.dto.AddProductDto;
import com.acme.inventory.dto.AddProductResponseDto;
import com.acme.inventory.dto.GetProductsResponseDto;
import com.acme.inventory.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api")
public class ProductsController {
  private final IProductService commandService;

  @Autowired
  public ProductsController(IProductService commandService) {
    this.commandService = commandService;
  }

  @PostMapping(value = "/product")
  public ResponseEntity<AddProductResponseDto> addProduct(@RequestBody AddProductDto productDto) {
    AddProductResponseDto addProductResponseDto = this.commandService.addProduct(productDto);
    return ResponseEntity.ok(addProductResponseDto);
  }

  @PostMapping("/product/{id}/stock/add")
  public ResponseEntity<Void> addStock(
          @RequestBody ProductStockDto stockDto, @PathVariable String id) {
    this.commandService.addStock(stockDto, id);

    return ResponseEntity.accepted().build();
  }

  @PostMapping("/product/{id}/stock/process")
  public ResponseEntity<Void> processStock(
      @RequestBody ProductStockDto stockDto, @PathVariable String id) {
    this.commandService.processStock(stockDto, id);

    return ResponseEntity.accepted().build();
  }

  @GetMapping("/product/{id}")
  public CompletableFuture<GetProductsResponseDto> getProduct(@PathVariable String id) {
    return this.commandService.getProduct(id);
  }
}
