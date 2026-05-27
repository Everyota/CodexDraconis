package com.example.rareza.Service;

import com.example.rareza.Model.Rareza;
import com.example.rareza.Repository.RarezaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RarezaService {

    @Autowired
    private RarezaRepository rarezaRepository;

    public List<Rareza> findAll() {
        return rarezaRepository.findAll();
    }

    public Rareza findById(int id) {
        return rarezaRepository.findById(id).orElse(null);
    }

    public Rareza create(Rareza rareza) {
        return rarezaRepository.save(rareza);
    }

    public Rareza update(int id, Rareza rareza) {
        Rareza buscado = findById(id);
        if (buscado != null) {
            buscado.setNombreRareza(rareza.getNombreRareza());
            buscado.setDescripcion(rareza.getDescripcion());
            buscado.setNivelRareza(rareza.getNivelRareza());
            return rarezaRepository.save(buscado);
        } else {
            return null;
        }
    }

    public boolean delete(int id) {
        Rareza buscado = findById(id);
        if (buscado != null) {
            rarezaRepository.delete(buscado);
            return true;
        } else {
            return false;
        }
    }
}
