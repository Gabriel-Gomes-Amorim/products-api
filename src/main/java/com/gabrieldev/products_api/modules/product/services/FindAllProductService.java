package com.gabrieldev.products_api.modules.product.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabrieldev.products_api.modules.product.entities.ProductEntity;
import com.gabrieldev.products_api.modules.product.repositories.ProductRepository;

@Service
public class FindAllProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<ProductEntity> execute() {
        return this.productRepository.findAll();
    }
}
