package com.example.pruebaBackend.services;
import com.example.pruebaBackend.dto.ProductoDto;
import com.example.pruebaBackend.dto.SucursalDto;
import com.example.pruebaBackend.exception.ResourceNotFoundException;
import com.example.pruebaBackend.model.Franquicia;
import com.example.pruebaBackend.model.Producto;
import com.example.pruebaBackend.model.Sucursal;
import com.example.pruebaBackend.repository.FranquiciaRepository;
import com.example.pruebaBackend.repository.ProductoRepository;
import com.example.pruebaBackend.repository.SucursalRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.Optional;

@Service
public class ProductoService {

    private final SucursalRepository sucursalRepository;
    private final ProductoRepository productoRepository;

    public ProductoService(SucursalRepository sucursalRepository, ProductoRepository productoRepository) {
        this.sucursalRepository = sucursalRepository;
        this.productoRepository = productoRepository;
    }

    public Producto agregarProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    public Producto obtenerProductoPorId(Long id) {
        return productoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Producto con ID " + id + " no encontrado"));
    }
    public Producto actualizarStock(Long id, Long nuevoStock) {
        Producto producto = obtenerProductoPorId(id);
        producto.setStock(nuevoStock);
        return productoRepository.save(producto);
    }

    public Producto  asignarProducto(Long sucursalId, Producto producto1) {
        Sucursal sucursal = sucursalRepository.findById(sucursalId)
                .orElseThrow(() -> new RuntimeException("Sucursal no encontrada"));
        producto1.setSucursalId(sucursal);
        if (producto1.getId() != null) {
            productoRepository.findById(producto1.getId())
                    .orElseThrow(() -> new ResourceNotFoundException("Producto con ID " + producto1.getId() + " no encontrado"));
        }
        return productoRepository.save(producto1);
    }

    public void eliminarProducto(Long sucursalId, ProductoDto productoDto) {
        Sucursal sucursal = sucursalRepository.findById(sucursalId)
                .orElseThrow(() -> new RuntimeException("Sucursal no encontrada"));
        if (productoDto.getId() == null) {
            throw new ResourceNotFoundException("Producto con ID " + productoDto.getId() + " no encontrado");
        }
        Producto producto = productoRepository.findById(productoDto.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Producto con ID " + productoDto.getId() + " no encontrado"));
        productoRepository.deleteById(productoDto.getId());
    }
}
