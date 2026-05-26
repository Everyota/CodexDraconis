package com.duoc.comentario.model;

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
@Table(name = "comentario")
public class Comentario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_comentario", nullable = false)
    private Integer id;

    @NotNull(message = "El id del usuario es obligatorio")
    @Column(name = "id_usuario", nullable = false)
    private Integer idUsuario;

    @NotNull(message = "El id de la criatura es obligatorio")
    @Column(name = "id_criatura", nullable = false)
    private Integer idCriatura;

    @NotBlank(message = "El contenido del comentario no puede estar vacío")
    @Column(name = "contenido", nullable = false)
    private String contenido;

    @Size(max = 20, message = "El estado del comentario no puede exceder los 20 caracteres")
    @ColumnDefault("'VISIBLE'")
    @Column(name = "estado_comentario", nullable = false, length = 20)
    private String estadoComentario;

    @CreationTimestamp
    @Column(name = "fecha_creacion", nullable = false)
    private Instant fechaCreacion;

    @UpdateTimestamp
    @Column(name = "fecha_actualizacion")
    private Instant fechaActualizacion;


}