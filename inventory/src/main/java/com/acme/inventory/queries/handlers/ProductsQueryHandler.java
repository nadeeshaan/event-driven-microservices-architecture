package com.acme.inventory.queries.handlers;

import com.acme.inventory.entities.ProductEntity;
import com.acme.inventory.queries.GetProductQuery;
import com.acme.inventory.dto.GetProductsResponseDto;
import com.acme.inventory.repository.ProductRepository;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductsQueryHandler {
  private final ProductRepository productRepository;

  @Autowired
  public ProductsQueryHandler(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  @QueryHandler
  public GetProductsResponseDto getProducts(GetProductQuery getProductQuery) {
    ProductEntity productEntity =
        productRepository.findById(getProductQuery.getProductId()).orElseThrow();

    return new GetProductsResponseDto(
        productEntity.getId(), productEntity.getKind(), productEntity.getUnitPrice());
  }
}
