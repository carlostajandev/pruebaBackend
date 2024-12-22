package com.example.pruebaBackend.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CrearFranquiciaDto {
    @NotBlank(message = "nombre es obligatorio")
    private String nombre;
}
