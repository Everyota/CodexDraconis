package com.duoc.comentario.service;

import com.duoc.comentario.model.Comentario;
import com.duoc.comentario.repository.ComentarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class ComentarioService {
    @Autowired
    private ComentarioRepository comentarioRepository;

    public List<Comentario> findAll() {
        return comentarioRepository.findAll();
    }

    public Comentario findById(int id) {
        return comentarioRepository.findById(id).orElse(null);
    }

    public Comentario create(Comentario comentario) {
        return comentarioRepository.save(comentario);
    }

    public Comentario update(int id, Comentario comentario) {
        Comentario buscado = findById(id);
        if (buscado != null) {
            buscado.setIdUsuario(comentario.getIdUsuario());
            buscado.setIdCriatura(comentario.getIdCriatura());
            buscado.setContenido(comentario.getContenido());
            buscado.setEstadoComentario(comentario.getEstadoComentario());

            return comentarioRepository.save(buscado);
        } else {
            return null;
        }
    }

    public boolean delete(int id) {
        Comentario buscado = findById(id);
        if (buscado != null) {
            comentarioRepository.delete(buscado);
            return true;
        } else {
            return false;
        }
    }
}
