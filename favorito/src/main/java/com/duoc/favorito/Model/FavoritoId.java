package com.duoc.favorito.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Embeddable
public class FavoritoId implements Serializable {
    private static final long serialVersionUID = -4966287770516817904L;
    @NotNull(message = "El id del usuario es obligatorio")
    @Column(name = "id_usuario", nullable = false)
    private Integer idUsuario;

    @NotNull(message= "El id de la criatura es obligatorio")
    @Column(name = "id_criatura", nullable = false)
    private Integer idCriatura;


}