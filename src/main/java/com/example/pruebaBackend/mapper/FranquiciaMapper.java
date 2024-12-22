package com.example.pruebaBackend.mapper;

import com.example.pruebaBackend.dto.CrearFranquiciaDto;
import com.example.pruebaBackend.dto.FranquiciaDto;
import com.example.pruebaBackend.model.Franquicia;

public final class FranquiciaMapper {

    public static  FranquiciaDto toDto(Franquicia model){
        if(model == null){
            return null;
        }
        FranquiciaDto dto = new FranquiciaDto();
        dto.setId(model.getId());
        dto.setNombre(model.getNombre());
        dto.setSucursales(model.getSucursales().stream().map(SucursalMapper::toDto).toList());
        return dto;
    }

    public static Franquicia toModel(FranquiciaDto dto){
        if(dto == null){
            return null;
        }
        Franquicia model = new Franquicia();
        model.setId(dto.getId());
        model.setNombre(dto.getNombre());
        model.setSucursales(dto.getSucursales().stream().map(SucursalMapper::toModel).toList());
        return model;
    }

    public static Franquicia toModel(CrearFranquiciaDto dto){
        if(dto == null){
            return null;
        }
        Franquicia model = new Franquicia();
        model.setNombre(dto.getNombre());
        return model;
    }
}
