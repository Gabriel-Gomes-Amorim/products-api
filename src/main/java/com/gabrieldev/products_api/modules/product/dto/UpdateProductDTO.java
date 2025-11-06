package com.gabrieldev.products_api.modules.product.dto;

import java.math.BigDecimal;
public record UpdateProductDTO(
        String name,
        BigDecimal price
) {}


