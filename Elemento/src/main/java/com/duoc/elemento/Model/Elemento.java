package com.duoc.elemento.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "elemento")
public class Elemento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_elemento", nullable = false)
    private Integer id;

    @Column(name = "nombre_elemento", nullable = false, length = 80)
    private String nombreElemento;

    @Column(name = "descripcion")
    private String descripcion;

    @ColumnDefault("current_timestamp()")
    @Column(name = "fecha_creacion", nullable = false)
    private Instant fechaCreacion;

    @Column(name = "fecha_actualizacion")
    private Instant fechaActualizacion;


}