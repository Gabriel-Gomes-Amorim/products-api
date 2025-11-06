package com.gabrieldev.products_api.modules.product.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabrieldev.products_api.exceptions.ProductAlreadyExistsException;
import com.gabrieldev.products_api.modules.product.dto.CreateProductDTO;
import com.gabrieldev.products_api.modules.product.entities.ProductEntity;
import com.gabrieldev.products_api.modules.product.repositories.ProductRepository;

@Service
public class CreateProductService {
    @Autowired
    private ProductRepository productRepository;

    public ProductEntity execute(CreateProductDTO productDTO) {
        this.productRepository.findByName(productDTO.name())
            .ifPresent(product -> {
                throw new ProductAlreadyExistsException();
            });

        ProductEntity product = new ProductEntity();
        product.setName(productDTO.name());
        product.setPrice(productDTO.price());

        return this.productRepository.save(product);
    }
}
