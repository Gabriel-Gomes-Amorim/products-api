package com.gabrieldev.products_api.modules.product.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabrieldev.products_api.exceptions.ProductNotFoundException;
import com.gabrieldev.products_api.modules.product.dto.UpdateProductDTO;
import com.gabrieldev.products_api.modules.product.entities.ProductEntity;
import com.gabrieldev.products_api.modules.product.repositories.ProductRepository;

@Service
public class UpdateProductService {
    @Autowired
    private ProductRepository productRepository;

    public ProductEntity execute(UUID productId ,UpdateProductDTO updateProductDTO) {
        ProductEntity product = this.productRepository.findById(productId)
                    .orElseThrow(() -> {
                        throw new ProductNotFoundException();
                    });

        if (updateProductDTO.name() != null && !updateProductDTO.name().isBlank()) {
            product.setName(updateProductDTO.name());
        }

        if (updateProductDTO.price() != null) {
            product.setPrice(updateProductDTO.price());
        }

        return this.productRepository.save(product);
    }
}
