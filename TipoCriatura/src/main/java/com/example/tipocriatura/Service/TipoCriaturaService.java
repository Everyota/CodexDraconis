package com.example.tipocriatura.Service;

import com.example.tipocriatura.Model.TipoCriatura;
import com.example.tipocriatura.Repository.TipoCriaturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoCriaturaService {
    @Autowired
    private TipoCriaturaRepository tipoCriaturaRepository;

    public List<TipoCriatura> findAll() {
        return tipoCriaturaRepository.findAll();
    }

    public TipoCriatura findById(int id) {
        return tipoCriaturaRepository.findById(id).orElse(null);
    }

    public TipoCriatura create(TipoCriatura tipoCriatura) {
        return tipoCriaturaRepository.save(tipoCriatura);
    }

    public TipoCriatura update(int id, TipoCriatura tipoCriatura) {
        TipoCriatura buscado = findById(id);
        if (buscado != null) {
            buscado.setNombreTipo(tipoCriatura.getNombreTipo());
            buscado.setDescripcion(tipoCriatura.getDescripcion());
            return tipoCriaturaRepository.save(buscado);
        } else {
            return null;
        }
    }

    public boolean delete(int id) {
        TipoCriatura buscado = findById(id);
        if (buscado != null) {
            tipoCriaturaRepository.delete(buscado);
            return true;
        } else {
            return false;
        }
    }
}
