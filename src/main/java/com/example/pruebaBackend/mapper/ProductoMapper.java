package com.example.pruebaBackend.mapper;


import com.example.pruebaBackend.dto.ProductoDto;
import com.example.pruebaBackend.model.Producto;

public final class ProductoMapper {

    private ProductoMapper() {
        // Private constructor to prevent instantiation (utility class)
    }

    public static ProductoDto toDto(Producto product) {
        if (product == null) {
            return null;
        }

        ProductoDto productDto = new ProductoDto();
        productDto.setId(product.getId());
        productDto.setNombre(product.getNombre());
        productDto.setStock(product.getStock());

        return productDto;
    }

    public static Producto toModel(ProductoDto productDto) {
        if (productDto == null) {
            return null;
        }

        Producto product = new Producto();
        product.setId(productDto.getId());
        product.setNombre(productDto.getNombre());
        product.setStock(productDto.getStock());

        return product;
    }
}
