package com.duoc.favorito.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "favorito")
public class Favorito {
    @EmbeddedId
    private FavoritoId id;

    @CreationTimestamp
    @Column(name = "fecha_guardado", nullable = false)
    private Instant fechaGuardado;


    @Column(name = "nota_personal")
    private String notaPersonal;


}