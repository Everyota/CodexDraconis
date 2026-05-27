package com.duoc.criaturahabitat.model;

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
public class CriaturaHabitatId implements Serializable {
    private static final long serialVersionUID = -5562579837350165432L;
    @NotNull(message = "El id de criatura es obligatorio")
    @Column(name = "id_criatura", nullable = false)
    private Integer idCriatura;

    @NotNull(message = "El id de habitat es obligatorio")
    @Column(name = "id_habitat", nullable = false)
    private Integer idHabitat;


}