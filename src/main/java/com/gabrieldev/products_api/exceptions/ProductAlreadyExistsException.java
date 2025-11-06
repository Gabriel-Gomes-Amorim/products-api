package com.gabrieldev.products_api.exceptions;

public class ProductAlreadyExistsException extends RuntimeException {
    public ProductAlreadyExistsException() {
        super("Product already exists");
    }   
}
