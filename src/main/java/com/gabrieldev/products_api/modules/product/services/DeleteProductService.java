package com.gabrieldev.products_api.modules.product.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabrieldev.products_api.exceptions.ProductNotFoundException;
import com.gabrieldev.products_api.modules.product.entities.ProductEntity;
import com.gabrieldev.products_api.modules.product.repositories.ProductRepository;

@Service
public class DeleteProductService {
    @Autowired
    private ProductRepository productRepository;

    public void execute(UUID productId) {
        ProductEntity product = this.productRepository.findById(productId)
                    .orElseThrow(() -> {
                        throw new ProductNotFoundException();
                    });

        this.productRepository.delete(product);
    }
}
