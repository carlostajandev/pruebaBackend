package com.example.pruebaBackend.dto;

import com.example.pruebaBackend.model.Sucursal;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductoDto {
    private Long id;

    private String nombre;

    private Long stock;

    private SucursalDto sucursal;
}
