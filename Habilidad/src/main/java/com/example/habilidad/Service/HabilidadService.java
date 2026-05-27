package com.example.habilidad.Service;

import com.example.habilidad.Model.Habilidad;
import com.example.habilidad.Repository.HabilidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HabilidadService {
    @Autowired
    private HabilidadRepository habilidadRepository;

    public List<Habilidad> findAll() {
        return habilidadRepository.findAll();
    }

    public Habilidad findById(int id) {
        return habilidadRepository.findById(id).orElse(null);
    }

    public Habilidad create(Habilidad habilidad) {
        return habilidadRepository.save(habilidad);
    }

    public Habilidad update(int id, Habilidad habilidad) {
        Habilidad buscado = findById(id);
        if (buscado != null) {
            buscado.setIdCriatura(habilidad.getIdCriatura());
            buscado.setNombreHabilidad(habilidad.getNombreHabilidad());
            buscado.setDescripcion(habilidad.getDescripcion());
            buscado.setTipoHabilidad(habilidad.getTipoHabilidad());
            buscado.setPoderBase(habilidad.getPoderBase());
            buscado.setNivelDominio(habilidad.getNivelDominio());
            return habilidadRepository.save(buscado);
        } else {
            return null;
        }
    }

    public boolean delete(int id) {
        Habilidad buscado = findById(id);
        if (buscado != null) {
            habilidadRepository.delete(buscado);
            return true;
        } else {
            return false;
        }
    }
}
