package com.gabrieldev.products_api.modules.product.repositories;

import com.gabrieldev.products_api.modules.product.entities.ProductEntity;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
public interface ProductRepository extends JpaRepository<ProductEntity, UUID> {
    Optional<ProductEntity> findByName(String name);
}

