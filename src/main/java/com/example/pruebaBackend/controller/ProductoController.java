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

    @PostMapping
    public ResponseEntity<ProductoDto> agregarProducto(@RequestBody ProductoDto producto) {
        return ResponseEntity.ok(ProductoMapper.toDto(productoService.agregarProducto(ProductoMapper.toModel(producto))));
    }

    @PatchMapping("actualizar-stock/{id}")
    public ResponseEntity<Producto> actualizarStock(@PathVariable Long id, @RequestBody Long nuevoStock) {
        return ResponseEntity.ok(productoService.actualizarStock(id, nuevoStock));
    }

    @PutMapping("actualizar-nombre/{id}")
    public ResponseEntity<ProductoDto> actualizarNombreProducto(@PathVariable Long id , @RequestBody CrearProductoDto nuevoNombre) {
        ProductoDto productoDto = new ProductoDto();
        productoDto.setId(id);
        productoDto.setNombre(nuevoNombre.getNombre());
        return ResponseEntity.ok(ProductoMapper.toDto(productoService.agregarProducto(ProductoMapper.toModel(productoDto))));
    }

    @GetMapping("/mayor-stock/{sucursalId}")
    public ResponseEntity<Producto> obtenerProductoConMayorStock(@PathVariable Long sucursalId) {
        return productoService.obtenerProductoConMayorStock(sucursalId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.noContent().build());
    }

    @PostMapping("/{sucursalId}/asignar-producto")
    public ResponseEntity<Producto> agregarProducto(
            @PathVariable Long sucursalId,
            @RequestBody ProductoDto productoDto) {
        Producto nuevoProducto = productoService.asignarProducto(sucursalId, productoDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoProducto);
    }

    @DeleteMapping("/{sucursalId}/eliminar-producto")
    public ResponseEntity<Void> eliminarProducto(
            @PathVariable Long sucursalId,
            @RequestBody ProductoDto productoDto) {
        productoService.eliminarProducto(sucursalId, productoDto);
        return ResponseEntity.noContent().build();
    }
}