package com.acme.inventory.projections;

import com.acme.inventory.entities.ProductEntity;
import com.acme.inventory.events.products.ProductAddedEvent;
import com.acme.inventory.events.products.StockAddedEvent;
import com.acme.inventory.events.products.StockProcessedEvent;
import com.acme.inventory.repository.ProductRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductProjectionEventHandler {
  private final ProductRepository productRepository;

  @Autowired
  public ProductProjectionEventHandler(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  @EventHandler
  public void on(ProductAddedEvent event) {
    ProductEntity productEntity =
        new ProductEntity(
            event.getProductId(),
            event.getName(),
            event.getUnitPrice(),
            0.0,
            event.getProductKind());
    productRepository.save(productEntity);
  }

  @EventHandler
  public void on(StockAddedEvent event) {
    ProductEntity productEntity =
        this.productRepository.findById(event.getProductId()).orElseThrow();
    productEntity.setStock(productEntity.getStock() + event.getStock());

    productRepository.save(productEntity);
  }

  @EventHandler
  public void on(StockProcessedEvent event) {
    ProductEntity productEntity =
        this.productRepository.findById(event.getProductId()).orElseThrow();
    productEntity.setStock(productEntity.getStock() + event.getStock());

    productRepository.save(productEntity);
  }
}
