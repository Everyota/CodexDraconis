package com.example.habitat.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "habitat")
public class Habitat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_habitat", nullable = false)
    private Integer id;

    @Size(max = 100)
    @NotBlank(message = "Espacio obligatorio")
    @Column(name = "nombre_habitat", nullable = false, length = 100)
    private String nombreHabitat;

    @Size(max = 40)
    @NotBlank(message = "Espacio obligatorio")
    @Column(name = "clima", nullable = false, length = 40)
    private String clima;

    @Column(name = "descripcion")
    private String descripcion;

    @NotNull(message = "Espacio obligatorio")
    @Column(name = "nivel_hostilidad", nullable = false)
    private Integer nivelHostilidad;

    @CreationTimestamp
    @Column(name = "fecha_creacion", nullable = false)
    private Instant fechaCreacion;

    @UpdateTimestamp
    @Column(name = "fecha_actualizacion")
    private Instant fechaActualizacion;


}