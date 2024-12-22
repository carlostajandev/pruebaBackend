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

    private SucursalRepository sucursalRepository;
    private final ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
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

    public Optional<Producto> obtenerProductoConMayorStock(Long sucursalId) {
        return productoRepository.findAll().stream()
                .filter(producto -> producto.getId().equals(sucursalId))
                .max(Comparator.comparingLong(Producto::getStock));
    }

    public Producto  asignarProducto(Long sucursalId, ProductoDto productoDto) {
        Sucursal sucursal = sucursalRepository.findById(sucursalId)
                .orElseThrow(() -> new RuntimeException("Sucursal no encontrada"));

        Producto producto = new Producto();
        producto.setNombre(productoDto.getNombre());
        sucursal.getProductos().add(producto);
        return productoRepository.save(producto);
    }

    public void eliminarProducto(Long sucursalId, ProductoDto productoDto) {
        Sucursal sucursal = sucursalRepository.findById(sucursalId)
                .orElseThrow(() -> new RuntimeException("Sucursal no encontrada"));

        Producto producto = new Producto();
        producto.setNombre(productoDto.getNombre());
        sucursal.getProductos().remove(producto);
        productoRepository.deleteById(productoDto.getId());
    }
}
