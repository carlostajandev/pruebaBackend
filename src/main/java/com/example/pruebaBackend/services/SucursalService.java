package com.example.pruebaBackend.services;
import com.example.pruebaBackend.dto.SucursalDto;
import com.example.pruebaBackend.exception.ResourceNotFoundException;
import com.example.pruebaBackend.model.Franquicia;
import com.example.pruebaBackend.model.Sucursal;
import com.example.pruebaBackend.repository.FranquiciaRepository;
import com.example.pruebaBackend.repository.SucursalRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class SucursalService {

    private FranquiciaRepository franquiciaRepository;
    private final SucursalRepository sucursalRepository;

    public SucursalService(SucursalRepository sucursalRepository) {
        this.sucursalRepository = sucursalRepository;
    }

    public Sucursal agregarSucursal(Sucursal sucursal) {
        return sucursalRepository.save(sucursal);
    }

    public Sucursal obtenerSucursalPorId(Long id) {
        return sucursalRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Sucursal con ID " + id + " no encontrada"));
    }

    public Sucursal asignarSucursal(Long franquiciaId, SucursalDto sucursalDto) {
        Franquicia franquicia = franquiciaRepository.findById(franquiciaId)
                .orElseThrow(() -> new RuntimeException("Franquicia no encontrada"));

        Sucursal sucursal = new Sucursal();
        sucursal.setNombre(sucursalDto.getNombre());
        franquicia.getSucursales().add(sucursal);
        return sucursalRepository.save(sucursal);
    }
}
