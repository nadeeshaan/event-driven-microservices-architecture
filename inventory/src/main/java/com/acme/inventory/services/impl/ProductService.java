package com.acme.inventory.services.impl;

import com.acme.inventory.dto.AddProductDto;
import com.acme.inventory.dto.AddProductResponseDto;
import com.acme.inventory.dto.GetProductsResponseDto;
import com.acme.inventory.dto.ProductStockDto;
import com.acme.inventory.queries.GetProductQuery;
import com.acme.inventory.commands.products.AddProductCommand;
import com.acme.inventory.commands.products.AddStockCommand;
import com.acme.inventory.commands.products.ProcessStockCommand;
import com.acme.inventory.services.IProductService;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
public class ProductService implements IProductService {

  private final CommandGateway commandGateway;

  private final QueryGateway queryGateway;

  @Autowired
  public ProductService(CommandGateway commandGateway, QueryGateway queryGateway) {
    this.commandGateway = commandGateway;
    this.queryGateway = queryGateway;
  }

  @Override
  public AddProductResponseDto addProduct(AddProductDto productDto) {
    UUID productId = UUID.randomUUID();
    AddProductCommand command =
        new AddProductCommand(
            productId.toString(),
            productDto.getProductKind(),
            productDto.getName(),
            productDto.getDescription(),
            productDto.getPrice());
    this.commandGateway.send(command);

    return new AddProductResponseDto(productId.toString());
  }

  public void addStock(ProductStockDto stockDto, String productId) {
    AddStockCommand command = new AddStockCommand(productId, stockDto.getQuantity());
    this.commandGateway.send(command);
  }

  @Override
  public void processStock(ProductStockDto stockDto, String productId) {
    ProcessStockCommand command = new ProcessStockCommand(productId, stockDto.getQuantity());
    this.commandGateway.send(command);
  }

  @Override
  public CompletableFuture<GetProductsResponseDto> getProduct(String productId) {
    return this.queryGateway.query(new GetProductQuery(productId), GetProductsResponseDto.class);
  }
}
