package com.example.pruebaBackend.mapper;

import com.example.pruebaBackend.dto.CrearSucursalDto;
import com.example.pruebaBackend.dto.SucursalDto;
import com.example.pruebaBackend.model.Sucursal;

public final class SucursalMapper {
    private SucursalMapper(){}
    public static Sucursal toModel(SucursalDto dto) {
        if (dto == null) {
            return null;
        }
        Sucursal model = new Sucursal();
        model.setId(dto.getId());
        model.setNombre(dto.getNombre());
        model.setProductos(dto.getProductos().stream().map(ProductoMapper::toModel).toList());

        return model;
    }

    public static SucursalDto toDto(Sucursal model) {
        if (model == null) {
            return null;
        }
        SucursalDto dto = new SucursalDto();
        dto.setId(model.getId());
        dto.setNombre(model.getNombre());
        dto.setProductos(model.getProductos().stream().map(ProductoMapper::toDto).toList());
        return dto;
    }
    public static Sucursal toModel(CrearSucursalDto dto) {
        if (dto == null) {
            return null;
        }
        Sucursal model = new Sucursal();
        model.setNombre(dto.getNombre());
        return model;
    }

}
