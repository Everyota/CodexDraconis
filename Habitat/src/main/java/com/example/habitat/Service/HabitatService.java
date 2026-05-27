package com.example.habitat.Service;

import com.example.habitat.Model.Habitat;
import com.example.habitat.Repository.HabitatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HabitatService {
    @Autowired
    private HabitatRepository habitatRepository;

    public List<Habitat> findAll() {
        return habitatRepository.findAll();
    }

    public Habitat findById(int id) {
        return habitatRepository.findById(id).orElse(null);
    }

    public Habitat create(Habitat habitat) {
        return habitatRepository.save(habitat);
    }

    public Habitat update(int id, Habitat habitat) {
        Habitat buscado = findById(id);
        if (buscado != null) {
            buscado.setNombreHabitat(habitat.getNombreHabitat());
            buscado.setClima(habitat.getClima());
            buscado.setDescripcion(habitat.getDescripcion());
            buscado.setNivelHostilidad(habitat.getNivelHostilidad());
            return habitatRepository.save(buscado);
        } else {
            return null;
        }
    }

    public boolean delete(int id) {
        Habitat buscado = findById(id);
        if (buscado != null) {
            habitatRepository.delete(buscado);
            return true;
        } else {
            return false;
        }
    }
}
