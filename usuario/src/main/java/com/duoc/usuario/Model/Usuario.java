package com.duoc.usuario.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario", nullable = false)
    private Integer id;

    @Size(max = 50)
    @NotBlank(message = "El nickname es obligatorio")
    @Column(name = "nickname", nullable = false, length = 50)
    private String nickname;

    @Size(max = 80)
    @NotBlank(message = "Los nombres son obligatorios")
    @Column(name = "nombres", nullable = false, length = 80)
    private String nombres;

    @Size(max = 80)
    @NotBlank(message = "Los apellidos son obligatorios")
    @Column(name = "apellidos", nullable = false, length = 80)
    private String apellidos;

    @Size(max = 120)
    @NotBlank(message = "El correo es obligatorio")
    @Column(name = "correo", nullable = false, length = 120)
    private String correo;

    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;

    @Column(name = "foto_perfil")
    private byte[] fotoPerfil;

    @Column(name = "biografia")
    private String biografia;

    @Size(max = 2, message = "El valor de recibeNotificaciones debe ser 'SI' o 'NO'")
    @ColumnDefault("'SI'")
    @Column(name = "recibe_notificaciones", nullable = false, length = 2)
    private String recibeNotificaciones;

    @Size(max = 20, message = "El estado del usuario debe tener hasta 20 caracteres")
    @ColumnDefault("'ACTIVO'")
    @Column(name = "estado_usuario", nullable = false, length = 20)
    private String estadoUsuario;

    @CreationTimestamp
    @Column(name = "fecha_creacion", nullable = false)
    private Instant fechaCreacion;

    @Column(name = "fecha_actualizacion")
    @UpdateTimestamp
    private Instant fechaActualizacion;


}