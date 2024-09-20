package com.acme.inventory.aggregates.reservation;

import com.acme.inventory.commands.reservations.ClearReservedStockCommand;
import com.acme.inventory.commands.reservations.ProcessReservedStockCommand;
import com.acme.inventory.commands.reservations.ReserveStockCommand;
import com.acme.inventory.events.reservations.ReservedStockClearedEvent;
import com.acme.inventory.events.reservations.ReservedStockProcessedEvent;
import com.acme.inventory.events.reservations.StockReservedEvent;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import java.time.Instant;

@Aggregate
@Entity
public class Reservation {
  @Id @AggregateIdentifier String id;

  String productId;
  String orderId;
  String date;
  Double quota;
  ReservationState reservationState;

  public Reservation() {}

  @CommandHandler
  public Reservation(ReserveStockCommand command) {
    AggregateLifecycle.apply(
        new StockReservedEvent(
            command.getId(),
            command.getProductId(),
            command.getOrderId(),
            command.getDate(),
            command.getQuota()));
  }

  @CommandHandler
  public void handle(ProcessReservedStockCommand command) {
    AggregateLifecycle.apply(
        new ReservedStockProcessedEvent(
            this.id, Instant.now().toString(), this.productId, this.quota));
  }

  @CommandHandler
  public void handle(ClearReservedStockCommand command) {
    this.reservationState = ReservationState.CLEARED;
    AggregateLifecycle.apply(
        new ReservedStockClearedEvent(
            this.id, Instant.now().toString(), this.productId, this.quota));
  }

  @EventSourcingHandler
  public void on(StockReservedEvent event) {
    this.id = event.getReservationId();
    this.productId = event.getProductId();
    this.orderId = event.getOrderId();
    this.date = event.getDate();
    this.quota = event.getQuota();
    this.reservationState = ReservationState.RESERVED;
  }

  @EventSourcingHandler
  public void on(ReservedStockProcessedEvent event) {
    this.reservationState = ReservationState.PROCESSED;
  }

  @EventSourcingHandler
  public void on(ReservedStockClearedEvent event) {
    this.reservationState = ReservationState.CLEARED;
  }
}
