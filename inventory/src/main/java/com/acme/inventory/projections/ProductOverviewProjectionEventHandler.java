package com.acme.inventory.projections;

import com.acme.inventory.entities.ProductManagementOverviewEntity;
import com.acme.inventory.events.products.ProductAddedEvent;
import com.acme.inventory.events.products.ProductDetailsUpdatedEvent;
import com.acme.inventory.events.products.StockAddedEvent;
import com.acme.inventory.events.products.StockProcessedEvent;
import com.acme.inventory.events.reservations.ReservedStockClearedEvent;
import com.acme.inventory.events.reservations.ReservedStockProcessedEvent;
import com.acme.inventory.events.reservations.StockReservedEvent;
import com.acme.inventory.repository.ProductOverviewRepository;
import java.time.Instant;
import java.util.UUID;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ProductOverviewProjectionEventHandler {
  private final ProductOverviewRepository productOverviewRepository;

  @Autowired
  public ProductOverviewProjectionEventHandler(
      ProductOverviewRepository productOverviewRepository) {
    this.productOverviewRepository = productOverviewRepository;
  }

  @EventHandler
  public void on(ProductAddedEvent event) {
    ProductManagementOverviewEntity productManagementOverviewEntity =
        new ProductManagementOverviewEntity(
            UUID.randomUUID().toString(),
            event.getProductId(),
            event.getName(),
            event.getDescription(),
            event.getUnitPrice(),
            0.0,
            null,
            null);
    productOverviewRepository.save(productManagementOverviewEntity);
  }

  @EventHandler
  @Transactional
  public void on(StockAddedEvent event) {
    ProductManagementOverviewEntity productManagementOverview =
        productOverviewRepository.findByProductId(event.getProductId()).orElseThrow();
    productManagementOverview.setLastRestockDate(Instant.now().toString());
    this.productOverviewRepository.save(productManagementOverview);
  }

  @EventHandler
  @Transactional
  public void on(StockProcessedEvent event) {
    ProductManagementOverviewEntity productManagementOverview =
        productOverviewRepository.findByProductId(event.getProductId()).orElseThrow();
    productManagementOverview.setReservations(
        productManagementOverview.getReservations() - event.getStock());

    this.productOverviewRepository.save(productManagementOverview);
  }

  @EventHandler
  @Transactional
  public void on(ProductDetailsUpdatedEvent event) {
    ProductManagementOverviewEntity productManagementOverviewEntity =
        this.productOverviewRepository.findByProductId(event.getProductId()).orElseThrow();

    if (event.getUnitPrice() != null) {
      productManagementOverviewEntity.setUnitPrice(event.getUnitPrice());
    }

    this.productOverviewRepository.save(productManagementOverviewEntity);
  }

  @EventHandler
  @Transactional
  public void on(StockReservedEvent event) {
    ProductManagementOverviewEntity productManagementOverviewEntity =
        this.productOverviewRepository.findByProductId(event.getProductId()).orElseThrow();
    productManagementOverviewEntity.setReservations(event.getQuota());

    this.productOverviewRepository.save(productManagementOverviewEntity);
  }

  @EventHandler
  @Transactional
  public void on(ReservedStockClearedEvent event) {
    ProductManagementOverviewEntity productManagementOverviewEntity =
        this.productOverviewRepository.findByProductId(event.getProductId()).orElseThrow();
    productManagementOverviewEntity.setReservations(
        productManagementOverviewEntity.getReservations() - event.getQuota());

    this.productOverviewRepository.save(productManagementOverviewEntity);
  }

  @EventHandler
  @Transactional
  public void on(ReservedStockProcessedEvent event) {
    ProductManagementOverviewEntity productManagementOverviewEntity =
        this.productOverviewRepository.findByProductId(event.getProductId()).orElseThrow();
    productManagementOverviewEntity.setReservations(
        productManagementOverviewEntity.getReservations() - event.getQuota());

    this.productOverviewRepository.save(productManagementOverviewEntity);
  }
}
