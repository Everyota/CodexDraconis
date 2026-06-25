package com.duoc.acceso.DTO;

import lombok.Data;

@Data
public class UsuarioDTO {
    private Integer id;
    private String nickname;
    private String correo;
    private String nombres;
    private String apellidos;
}
