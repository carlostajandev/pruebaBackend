package com.example.pruebaBackend.services;
import com.example.pruebaBackend.dto.SucursalDto;
import com.example.pruebaBackend.exception.ResourceNotFoundException;
import com.example.pruebaBackend.model.Franquicia;
import com.example.pruebaBackend.model.Producto;
import com.example.pruebaBackend.model.Sucursal;
import com.example.pruebaBackend.repository.FranquiciaRepository;
import com.example.pruebaBackend.repository.SucursalRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class SucursalService {

    private final FranquiciaRepository franquiciaRepository;
    private final SucursalRepository sucursalRepository;

    public SucursalService(FranquiciaRepository franquiciaRepository, SucursalRepository sucursalRepository) {
        this.franquiciaRepository = franquiciaRepository;
        this.sucursalRepository = sucursalRepository;
    }

    public Sucursal agregarSucursal(Sucursal sucursal) {
        return sucursalRepository.save(sucursal);
    }

    public Sucursal asignarSucursal(Long franquiciaId, Sucursal sucursal1) {
        Franquicia franquicia = franquiciaRepository.findById(franquiciaId)
                .orElseThrow(() -> new RuntimeException("Franquicia no encontrada"));
        sucursal1.setFranquiciaId(franquicia);
        if (sucursal1.getId() != null) {
            sucursalRepository.findById(sucursal1.getId())
                    .orElseThrow(() -> new ResourceNotFoundException("Sucursal con ID " + sucursal1.getId() + " no encontrado"));
        }
        return sucursalRepository.save(sucursal1);
    }

}
