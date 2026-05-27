package com.example.habilidad.Model;

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
@Table(name = "habilidad")
public class Habilidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_habilidad", nullable = false)
    private Integer id;

    @NotNull(message = "Espacio obligatorio")
    @Column(name = "id_criatura", nullable = false)
    private Integer idCriatura;

    @Size(max = 120)
    @NotBlank(message = "Espacio obligatorio")
    @Column(name = "nombre_habilidad", nullable = false, length = 120)
    private String nombreHabilidad;

    @NotBlank(message = "Espacio obligatorio")
    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @Size(max = 40)
    @NotBlank(message = "Espacio obligatorio")
    @Column(name = "tipo_habilidad", nullable = false, length = 40)
    private String tipoHabilidad;

    @NotNull(message = "Espacio obligatorio")
    @Column(name = "poder_base", nullable = false)
    private Integer poderBase;

    @NotNull(message = "Espacio obligatorio")
    @Column(name = "nivel_dominio", nullable = false)
    private Integer nivelDominio;

    @CreationTimestamp
    @Column(name = "fecha_creacion", nullable = false)
    private Instant fechaCreacion;

    @UpdateTimestamp
    @Column(name = "fecha_actualizacion")
    private Instant fechaActualizacion;


}