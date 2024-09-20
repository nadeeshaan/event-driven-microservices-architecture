package com.acme.inventory.repository;

import com.acme.inventory.entities.ProductManagementOverviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductOverviewRepository
    extends JpaRepository<ProductManagementOverviewEntity, String> {
    Optional<ProductManagementOverviewEntity> findByProductId(String productId);
}
