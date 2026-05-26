package com.example.criatura.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "criatura")
public class Criatura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_criatura", nullable = false)
    private Integer id;

    @NotNull(message = "Espacio obligatorio")
    @Column(name = "id_tipo_criatura", nullable = false)
    private Integer idTipoCriatura;

    @NotNull(message = "Espacio obligatorio")
    @Column(name = "id_rareza", nullable = false)
    private Integer idRareza;

    @NotNull(message = "Espacio obligatorio")
    @Column(name = "id_usuario_creador", nullable = false)
    private Integer idUsuarioCreador;

    @Size(max = 120)
    @NotBlank(message = "Espacio obligatorio")
    @Column(name = "nombre_criatura", nullable = false, length = 120)
    private String nombreCriatura;

    @NotBlank(message = "Espacio obligatorio")
    @Lob
    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @Size(max = 200)
    @Column(name = "origen_leyenda", length = 200)
    private String origenLeyenda;

    @NotNull(message = "Espacio obligatorio")
    @Column(name = "nivel_peligro", nullable = false)
    private Integer nivelPeligro;

    @Column(name = "altura_metros", precision = 5, scale = 2)
    private BigDecimal alturaMetros;

    @Column(name = "peso_kg", precision = 8, scale = 2)
    private BigDecimal pesoKg;

    @Column(name = "imagen_criatura")
    private byte[] imagenCriatura;

    @Size(max = 30)
    @NotBlank(message = "Espacio obligatorio")
    @ColumnDefault("'PENDIENTE'")
    @Column(name = "estado_registro", nullable = false, length = 30)
    private String estadoRegistro;

    @CreationTimestamp
    @Column(name = "fecha_creacion", nullable = false)
    private Instant fechaCreacion;

    @UpdateTimestamp
    @Column(name = "fecha_actualizacion")
    private Instant fechaActualizacion;


}