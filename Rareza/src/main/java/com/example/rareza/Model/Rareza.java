package com.example.rareza.Model;

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
@Table(name = "rareza")
public class Rareza {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rareza", nullable = false)
    private Integer id;

    @Size(max = 80)
    @NotBlank(message = "Espacio obligatorio")
    @Column(name = "nombre_rareza", nullable = false, length = 80)
    private String nombreRareza;

    @Column(name = "descripcion")
    private String descripcion;

    @NotNull(message = "Espacio obligatorio")
    @Column(name = "nivel_rareza", nullable = false)
    private Integer nivelRareza;

    @CreationTimestamp
    @Column(name = "fecha_creacion", nullable = false)
    private Instant fechaCreacion;

    @UpdateTimestamp
    @Column(name = "fecha_actualizacion")
    private Instant fechaActualizacion;


}