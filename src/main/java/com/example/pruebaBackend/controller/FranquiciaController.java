package com.example.pruebaBackend.controller;
import com.example.pruebaBackend.dto.CrearFranquiciaDto;
import com.example.pruebaBackend.dto.FranquiciaDto;
import com.example.pruebaBackend.mapper.FranquiciaMapper;
import com.example.pruebaBackend.services.FranquiciaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/franquicias")
public class FranquiciaController {

    private final FranquiciaService franquiciaService;

    public FranquiciaController(FranquiciaService franquiciaService) {
        this.franquiciaService = franquiciaService;
    }

    @PostMapping("/crear")
    public ResponseEntity<FranquiciaDto> agregarFranquicia(@RequestBody CrearFranquiciaDto nuevaFranquicia) {
        return ResponseEntity.ok(FranquiciaMapper.toDto(franquiciaService.agregarFranquicia(FranquiciaMapper.toModel(nuevaFranquicia))));
    }
    @PutMapping("actualizar-nombre/{id}")
    public ResponseEntity<FranquiciaDto> actualizarNombreFranquicia(@PathVariable Long id , @RequestBody CrearFranquiciaDto nuevoNombre) {
        FranquiciaDto franquiciaDto = new FranquiciaDto();
        franquiciaDto.setId(id);
        franquiciaDto.setNombre(nuevoNombre.getNombre());
        return ResponseEntity.ok(FranquiciaMapper.toDto(franquiciaService.agregarFranquicia(FranquiciaMapper.toModel(franquiciaDto))));
    }
    @GetMapping("mayor-stock/{id}")
    public ResponseEntity<List<Map<String, Object>>> obtenerMayorStock(@PathVariable Long id){
        return ResponseEntity.ok(franquiciaService.listaProductosMayorStock(id));
    }

}

