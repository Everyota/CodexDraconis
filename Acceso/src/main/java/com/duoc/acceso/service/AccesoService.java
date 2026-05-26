package com.duoc.acceso.service;

import com.duoc.acceso.model.Acceso;
import com.duoc.acceso.repository.AccesoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccesoService {
    @Autowired
    private AccesoRepository accesoRepository;

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
}
