package com.duoc.criaturaelemento.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Embeddable
public class CriaturaElementoId implements Serializable {
    private static final long serialVersionUID = 7583418708884398683L;
    @NotNull(message = "El id de criatura es obligatorio")
    @Column(name = "id_criatura", nullable = false)
    private Integer idCriatura;

    @NotNull(message = "El id de elemento es obligatorio")
    @Column(name = "id_elemento", nullable = false)
    private Integer idElemento;


}