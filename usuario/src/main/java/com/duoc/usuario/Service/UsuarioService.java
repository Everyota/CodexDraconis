package com.duoc.usuario.Service;

import com.duoc.usuario.Model.Usuario;
import com.duoc.usuario.Repository.UsuarioRepository;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    @Autowired
     private UsuarioRepository usuarioRepository;

    public List<Usuario> findAll() {return  usuarioRepository.findAll();}

    public Usuario findById(int id) {return usuarioRepository.findById(id).orElse(null);}

    public Usuario create(Usuario usuario) {return usuarioRepository.save(usuario);}

    public Usuario update(int id, Usuario usuario) {
        Usuario buscado = findById(id);
        if (buscado != null) {
            buscado.setNickname(usuario.getNickname());
            buscado.setNombres(usuario.getNombres());
            buscado.setApellidos(usuario.getApellidos());
            buscado.setCorreo(usuario.getCorreo());
            buscado.setFechaNacimiento(usuario.getFechaNacimiento());
            buscado.setFotoPerfil(usuario.getFotoPerfil());
            buscado.setBiografia(usuario.getBiografia());
            buscado.setRecibeNotificaciones(usuario.getRecibeNotificaciones());
            buscado.setEstadoUsuario(usuario.getEstadoUsuario());

            return usuarioRepository.save(buscado);
        } else {
            return null;
        }
    }

    public boolean delete(int id) {
        Usuario buscado = findById(id);
        if (buscado != null) {
            usuarioRepository.delete(buscado);
            return true;
        } else {
            return false;
        }
    }
}
