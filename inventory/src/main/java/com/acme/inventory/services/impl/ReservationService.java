package com.acme.inventory.services.impl;

import com.acme.inventory.commands.reservations.ReserveStockCommand;
import com.acme.inventory.dto.ReserveStockResponseDto;
import com.acme.inventory.dto.reservation.ReserveStockDto;
import com.acme.inventory.services.IReservationService;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Component
public class ReservationService implements IReservationService {
  private final CommandGateway commandGateway;

  @Autowired
  public ReservationService(CommandGateway commandGateway) {
    this.commandGateway = commandGateway;
  }

  @Override
  public CompletableFuture<ReserveStockResponseDto> reserveStock(ReserveStockDto reserveStockDto) {
    UUID reservationId = UUID.randomUUID();
    ReserveStockCommand reserveStockCommand =
        new ReserveStockCommand(
            reservationId.toString(),
            reserveStockDto.getProductId(),
            reserveStockDto.getOrderId(),
            Instant.now().toString(),
            reserveStockDto.getQuota());

    return commandGateway
        .send(reserveStockCommand)
        .thenApply(o -> new ReserveStockResponseDto(reservationId.toString()));
  }
}
