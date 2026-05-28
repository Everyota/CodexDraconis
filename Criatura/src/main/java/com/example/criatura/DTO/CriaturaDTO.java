package com.example.criatura.DTO;

import lombok.Data;

@Data
public class CriaturaDTO {
    private Integer id;
    private String nombreCriatura;
    private String descripcion;
    private TipoCriaturaDTO tipoCriatura;
    private RarezaDTO rareza;
}
