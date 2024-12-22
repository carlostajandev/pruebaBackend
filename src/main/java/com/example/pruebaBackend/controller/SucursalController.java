package com.example.pruebaBackend.controller;

import com.example.pruebaBackend.dto.*;
import com.example.pruebaBackend.mapper.FranquiciaMapper;
import com.example.pruebaBackend.mapper.ProductoMapper;
import com.example.pruebaBackend.mapper.SucursalMapper;
import com.example.pruebaBackend.model.Sucursal;
import com.example.pruebaBackend.services.SucursalService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sucursales")
public class SucursalController {

    private final SucursalService sucursalService;

    public SucursalController(SucursalService sucursalService) {
        this.sucursalService = sucursalService;
    }

    @PutMapping("actualizar-nombre/{id}")
    public ResponseEntity<SucursalDto> actualizarNombreSucursal(@PathVariable Long id , @RequestBody CrearSucursalDto nuevoNombre) {
        SucursalDto sucursalDto = new SucursalDto();
        sucursalDto.setId(id);
        sucursalDto.setNombre(nuevoNombre.getNombre());
        return ResponseEntity.ok(SucursalMapper.toDto(sucursalService.agregarSucursal(SucursalMapper.toModel(sucursalDto))));
    }

    @PostMapping("/{franquiciaId}/asignar-sucursal")
    public ResponseEntity<Sucursal> agregarSucursal(
            @PathVariable Long franquiciaId,
            @RequestBody SucursalDto sucursalDto) {
        Sucursal nuevaSucursal = sucursalService.asignarSucursal(franquiciaId, sucursalDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaSucursal);
    }
}
