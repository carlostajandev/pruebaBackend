package com.example.pruebaBackend.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
public class FranquiciaDto {
    private Long id;
    @NotBlank(message = "nombre es obligatorio")
    private String nombre;
    private List<SucursalDto> sucursales;
}
