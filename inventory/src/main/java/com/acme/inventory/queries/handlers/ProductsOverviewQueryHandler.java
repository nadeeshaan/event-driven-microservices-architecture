package com.acme.inventory.queries.handlers;

import com.acme.inventory.entities.ProductManagementOverviewEntity;
import com.acme.inventory.queries.GetProductQuery;
import com.acme.inventory.dto.GetProductOverviewResponseDto;
import com.acme.inventory.repository.ProductOverviewRepository;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductsOverviewQueryHandler {
  private final ProductOverviewRepository productOverviewRepository;

  @Autowired
  public ProductsOverviewQueryHandler(ProductOverviewRepository productOverviewRepository) {
    this.productOverviewRepository = productOverviewRepository;
  }

  @QueryHandler
  public GetProductOverviewResponseDto getProducts(GetProductQuery getProductQuery) {
    ProductManagementOverviewEntity productManagementOverviewEntity =
        productOverviewRepository.findById(getProductQuery.getProductId()).orElseThrow();

    return new GetProductOverviewResponseDto(
        productManagementOverviewEntity.getProductId(),
        productManagementOverviewEntity.getDescription(),
        productManagementOverviewEntity.getUnitPrice());
  }
}
