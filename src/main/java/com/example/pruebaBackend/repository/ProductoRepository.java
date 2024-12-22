package com.example.pruebaBackend.repository;
import com.example.pruebaBackend.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
//    @Query("")
    //List<Producto> getAllByFranquicia(Long franquiciaId)
}
