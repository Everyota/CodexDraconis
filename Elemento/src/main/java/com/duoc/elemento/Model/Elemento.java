package com.duoc.elemento.Model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "elemento")
@JsonPropertyOrder
public class Elemento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_elemento", nullable = false)
    private Integer id;

    @NotBlank(message = "El nombre del elemento es obligatorio")
    @Size(max = 80, message = "El nombre del elemento no puede exceder los 80 caracteres")
    @Column(name = "nombre_elemento", nullable = false, length = 80)
    private String nombreElemento;

    @NotBlank(message = "La descripción del elemento es obligatoria")
    @Column(name = "descripcion")
    private String descripcion;

    @CreationTimestamp
    @Column(name = "fecha_creacion", nullable = false)
    private Instant fechaCreacion;

    @UpdateTimestamp
    @Column(name = "fecha_actualizacion")
    private Instant fechaActualizacion;


}