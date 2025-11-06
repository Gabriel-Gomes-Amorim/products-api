package com.gabrieldev.products_api.modules.product.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gabrieldev.products_api.modules.product.dto.CreateProductDTO;
import com.gabrieldev.products_api.modules.product.dto.UpdateProductDTO;
import com.gabrieldev.products_api.modules.product.services.CreateProductService;
import com.gabrieldev.products_api.modules.product.services.DeleteProductService;
import com.gabrieldev.products_api.modules.product.services.FindAllProductService;
import com.gabrieldev.products_api.modules.product.services.FindByIdProductService;
import com.gabrieldev.products_api.modules.product.services.UpdateProductService;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    private CreateProductService createProductService;

    @Autowired
    private UpdateProductService updateProductService;

    @Autowired
    private FindByIdProductService findProductById;

    @Autowired
    private FindAllProductService findAllProductService;

    @Autowired
    private DeleteProductService deleteProductService;

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody CreateProductDTO productDTO) {
        try {
            var response = createProductService.execute(productDTO);
            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(
            @PathVariable UUID id,
            @RequestBody UpdateProductDTO updateProductDTO
    ) {
        try {
            var response = updateProductService.execute(
                    id,
                    updateProductDTO
            );

            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable UUID id) {
        try {
            return ResponseEntity.ok().body(findProductById.execute(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<Object> findAll() {
        try {
            return ResponseEntity.ok().body(findAllProductService.execute());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable UUID id) {
        try {
            deleteProductService.execute(id);
            return ResponseEntity.noContent().build(); 
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
