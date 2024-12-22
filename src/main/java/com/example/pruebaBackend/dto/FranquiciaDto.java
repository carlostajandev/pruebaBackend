package com.example.pruebaBackend.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FranquiciaDto {
    private Long id;
    @NotBlank(message = "nombre es obligatorio")
    private String nombre;
    private List<SucursalDto> sucursales;
}
