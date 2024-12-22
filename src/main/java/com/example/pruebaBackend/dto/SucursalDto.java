package com.example.pruebaBackend.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SucursalDto {
    private Long id;
    private String nombre;
    private List<ProductoDto> productos;
}
