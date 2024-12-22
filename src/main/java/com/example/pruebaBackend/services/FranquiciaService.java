package com.example.pruebaBackend.services;
import com.example.pruebaBackend.exception.ResourceNotFoundException;
import com.example.pruebaBackend.model.Franquicia;
import com.example.pruebaBackend.model.Producto;
import com.example.pruebaBackend.repository.FranquiciaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class FranquiciaService {

    private final FranquiciaRepository franquiciaRepository;

    public FranquiciaService(FranquiciaRepository franquiciaRepository) {
        this.franquiciaRepository = franquiciaRepository;
    }

    public Franquicia agregarFranquicia(Franquicia franquicia) {
        return franquiciaRepository.save(franquicia);
    }

    public List<Map<String, Object>> listaProductosMayorStock(Long franquiciaId){
        if (!franquiciaRepository.existsById(franquiciaId)) {
            throw new ResourceNotFoundException("Franquicia con ID " + franquiciaId + " no encontrada");
        }
        return franquiciaRepository.buscarProductosMayorStock(franquiciaId);
    }
}
