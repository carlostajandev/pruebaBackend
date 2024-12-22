package com.example.pruebaBackend.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Sucursal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @ManyToOne
    private Franquicia franquiciaId;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "sucursal_id")
    private List<Producto> productos;

}
