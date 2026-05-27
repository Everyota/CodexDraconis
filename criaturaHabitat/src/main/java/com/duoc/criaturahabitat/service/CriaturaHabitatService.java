package com.duoc.criaturahabitat.service;

import com.duoc.criaturahabitat.model.CriaturaHabitat;
import com.duoc.criaturahabitat.model.CriaturaHabitatId;
import com.duoc.criaturahabitat.repository.CriaturaHabitatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CriaturaHabitatService {
    @Autowired
    private CriaturaHabitatRepository criaturaHabitatRepository;

    public List<CriaturaHabitat> findAll(){
        return criaturaHabitatRepository.findAll();
    }

    public List<CriaturaHabitat> findByCriatura(int idCriatura){
        return criaturaHabitatRepository.findByIdIdCriatura(idCriatura);
    }

    public List<CriaturaHabitat> findByHabitat(int idHabitat){
        return criaturaHabitatRepository.findByIdIdHabitat(idHabitat);
    }

    public CriaturaHabitat create(CriaturaHabitat criaturaHabitat){
        return criaturaHabitatRepository.save(criaturaHabitat);
    }


    //Buscado es el criaturaHabitat que coincide con el id del habitat y el id criatura,
    //y si lo encuentra, lo elimina.
    public boolean delete(int idHabitat, int idCriatura) {
        CriaturaHabitatId criaturaHabitatId = new CriaturaHabitatId(idCriatura, idHabitat);
        CriaturaHabitat buscado = criaturaHabitatRepository.findById(criaturaHabitatId).orElse(null);
        if (buscado != null) {
            criaturaHabitatRepository.delete(buscado);
            return true;
        } else {
            return false;
        }
    }
}
