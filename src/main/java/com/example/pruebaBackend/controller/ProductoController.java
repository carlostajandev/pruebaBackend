package com.example.pruebaBackend.controller;

import com.example.pruebaBackend.dto.*;
import com.example.pruebaBackend.mapper.FranquiciaMapper;
import com.example.pruebaBackend.mapper.ProductoMapper;
import com.example.pruebaBackend.model.Producto;
import com.example.pruebaBackend.model.Sucursal;
import com.example.pruebaBackend.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    private final ProductoService productoService;
    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @PatchMapping("/actualizar-stock/{id}")
    public ResponseEntity<ProductoDto> actualizarStock(@PathVariable Long id, @RequestBody ProductoDto nuevoStock) {
        return ResponseEntity.ok(ProductoMapper.toDto(productoService.actualizarStock(id, nuevoStock.getStock())));
    }

    @PutMapping("/actualizar-nombre/{id}")
    public ResponseEntity<ProductoDto> actualizarNombreProducto(@PathVariable Long id , @RequestBody CrearProductoDto nuevoNombre) {
        ProductoDto productoDto = new ProductoDto();
        productoDto.setId(id);
        productoDto.setNombre(nuevoNombre.getNombre());
        return ResponseEntity.ok(ProductoMapper.toDto(productoService.agregarProducto(ProductoMapper.toModel(productoDto))));
    }

    @PostMapping("/asignar-producto/{sucursalId}")
    public ResponseEntity<ProductoDto> agregarProducto(
            @PathVariable Long sucursalId,
            @RequestBody ProductoDto productoDto) {
        Producto nuevoProducto = productoService.asignarProducto(sucursalId, ProductoMapper.toModel(productoDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(ProductoMapper.toDto(nuevoProducto));
    }

    @DeleteMapping("/eliminar-producto/{sucursalId}")
    public ResponseEntity<Void> eliminarProducto(
            @PathVariable Long sucursalId,
            @RequestBody ProductoDto productoDto) {
        productoService.eliminarProducto(sucursalId, productoDto);
        return ResponseEntity.noContent().build();
    }
}