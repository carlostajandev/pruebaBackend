package com.example.pruebaBackend.repository;
import com.example.pruebaBackend.model.Franquicia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface FranquiciaRepository extends JpaRepository<Franquicia, Long> {
    @Query(value = "SELECT p.nombre, p.stock, s.nombre as sucursal_nombre FROM franquicia f JOIN sucursal s ON f.id = s.franquicia_id JOIN producto p ON s.id = p.sucursal_id WHERE f.id = ?1 ORDER BY p.stock ASC", nativeQuery = true)
    List<Map<String, Object>> buscarProductosMayorStock(Long franquiciaId);
}
