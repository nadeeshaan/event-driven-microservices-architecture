package com.acme.inventory.services;

import com.acme.inventory.dto.ReserveStockResponseDto;
import com.acme.inventory.dto.reservation.ReserveStockDto;

import java.util.concurrent.CompletableFuture;

public interface IReservationService {
    CompletableFuture<ReserveStockResponseDto> reserveStock(ReserveStockDto reserveStockDto);


}
