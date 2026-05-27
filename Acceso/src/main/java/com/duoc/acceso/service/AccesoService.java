package com.duoc.acceso.service;

import com.duoc.acceso.Client.UsuarioClient;
import com.duoc.acceso.DTO.UsuarioDTO;
import com.duoc.acceso.model.Acceso;
import com.duoc.acceso.repository.AccesoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccesoService {
    @Autowired
    private AccesoRepository accesoRepository;
    @Autowired
    private UsuarioClient usuarioClient;

    public List<Acceso> findAll() {return  accesoRepository.findAll();}

    public Acceso findById(int id) {return accesoRepository.findById(id).orElse(null);}

    public Acceso create(Acceso acceso) {return accesoRepository.save(acceso);}

    public Acceso update(int id, Acceso acceso) {
        Acceso buscado = findById(id);
        if (buscado != null) {
            buscado.setPasswordHash(acceso.getPasswordHash());
            buscado.setRol(acceso.getRol());

            return accesoRepository.save(buscado);
        } else {
            return null;
        }
    }

    public boolean delete(int id) {
        Acceso buscado = findById(id);
        if (buscado != null) {
            accesoRepository.delete(buscado);
            return true;
        } else {
            return false;
        }
    }

    /*
    * 1- Usamos el cliente de usuario para buscar un usuario por nickname o correo
    * 2- Si existe, buscamos un acceso asociado al id de ese usuario
    * 3- Si existe, comparamos la contraseña de este acceso con la enviada*/
    public boolean login(String datoUsuario, String contrasenia) {
        try {
            UsuarioDTO usuario = usuarioClient.getUsuario(datoUsuario);
            if (usuario != null) {
                Acceso accesoUsuario = accesoRepository.findByIdUsuario(usuario.getId()).orElse(null);
                if (accesoUsuario != null) {
                    return accesoUsuario.getPasswordHash().equals(contrasenia);
                }
            }
        } catch (Exception e) {
            System.out.println("Error al llamar al microservicio de usuarios " + e.getMessage());
        }
        return false;
    }
}
