package com.example.pruebaBackend.dto;

import lombok.Data;

@Data
public class ProductoDto {
    private Long id;

    private String nombre;

    private Long stock;
}
