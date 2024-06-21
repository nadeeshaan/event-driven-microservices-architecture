package com.acme.inventory.aggregates.products;

import com.acme.inventory.commands.products.AddProductCommand;
import com.acme.inventory.commands.products.AddStockCommand;
import com.acme.inventory.events.products.StockProcessedEvent;
import com.acme.inventory.commands.products.ProcessStockCommand;
import com.acme.inventory.events.products.StockAddedEvent;
import com.acme.inventory.events.products.ProductAddedEvent;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
public class Product {
  @AggregateIdentifier
  String id;

  ProductKind productKind;
  String name;
  String description;
  Double unitPrice;
  int stock;

  public Product() {}

  @CommandHandler
  public Product(AddProductCommand command) {
    AggregateLifecycle.apply(
        new ProductAddedEvent(
            command.getId(),
            command.getProductKind(),
            command.getName(),
            command.getDescription(),
            command.getPrice()));
  }

  @CommandHandler
  public void handle(AddStockCommand command) {
    AggregateLifecycle.apply(new StockAddedEvent(command.getId(), command.getStock()));
  }

  @CommandHandler
  public void handle(ProcessStockCommand command) {
    AggregateLifecycle.apply(new StockProcessedEvent(command.getId(), command.getStock()));
  }

  @EventSourcingHandler
  public void on(ProductAddedEvent event) {
    this.id = event.getProductId();
    this.productKind = event.getProductKind();
    this.description = event.getDescription();
    this.unitPrice = event.getUnitPrice();
    this.name = event.getName();
    this.stock = 0;
  }

  @EventSourcingHandler
  public void on(StockAddedEvent event) {
    this.stock += event.getStock();
  }

  @EventSourcingHandler
  public void on(StockProcessedEvent event) {
    this.stock -= event.getStock();
  }
}
