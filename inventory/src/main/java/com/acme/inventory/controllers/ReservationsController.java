package com.acme.inventory.controllers;

import com.acme.inventory.dto.ReserveStockResponseDto;
import com.acme.inventory.dto.reservation.ReserveStockDto;
import com.acme.inventory.services.impl.ReservationService;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("reservation")
public class ReservationsController {

  private final ReservationService reservationService;

  @Autowired
  public ReservationsController(ReservationService reservationService) {
    this.reservationService = reservationService;
  }

  @PostMapping("/reserve")
  public CompletableFuture<ReserveStockResponseDto> reserve(ReserveStockDto reserveStockDto) {
    return this.reservationService.reserveStock(reserveStockDto);
  }
}
