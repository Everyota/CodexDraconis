package com.duoc.elemento.Service;

import com.duoc.elemento.ElementoApplication;
import com.duoc.elemento.Model.Elemento;
import com.duoc.elemento.Repository.ElementoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class ElementoService {
    @Autowired
    private ElementoRepository elementoRepository;

    public List<Elemento> findAll() {
        return elementoRepository.findAll();
    }

    public Elemento findById(int id) {
        return elementoRepository.findById(id).orElse(null);
    }

    public Elemento create(Elemento elemento) {
        return elementoRepository.save(elemento);
    }

    public Elemento update(int id, Elemento elemento) {
        Elemento buscado = findById(id);
        if (buscado != null) {
            buscado.setNombreElemento(elemento.getNombreElemento());
            buscado.setDescripcion(elemento.getDescripcion());
            buscado.setFechaActualizacion(Instant.now());
            return elementoRepository.save(buscado);
        } else {
            return null;
        }
    }

    public boolean delete(int id) {
        Elemento buscado = findById(id);
        if (buscado != null) {
            elementoRepository.delete(buscado);
            return true;
        } else {
            return false;
        }
    }
}
