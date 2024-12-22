package com.example.pruebaBackend.dto;

import lombok.Data;

import java.util.List;

@Data
public class SucursalDto {
    private Long id;
    private String nombre;
    private List<ProductoDto> productos;
}
