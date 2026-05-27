package com.duoc.criaturaelemento.service;

import com.duoc.criaturaelemento.model.CriaturaElemento;
import com.duoc.criaturaelemento.model.CriaturaElementoId;
import com.duoc.criaturaelemento.repository.CriaturaElementoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CriaturaElementoService {
    @Autowired
    private CriaturaElementoRepository criaturaElementoRepository;

    public List<CriaturaElemento> findAll(){
        return criaturaElementoRepository.findAll();
    }

    public List<CriaturaElemento> findByCriatura(int idCriatura){
        return criaturaElementoRepository.findByIdIdCriatura(idCriatura);
    }

    public List<CriaturaElemento> findByElemento(int idElemento){
        return criaturaElementoRepository.findByIdIdElemento(idElemento);
    }

    public CriaturaElemento create(CriaturaElemento criaturaElemento){
        return criaturaElementoRepository.save(criaturaElemento);
    }


    //Buscado es el criaturaElemento que coincide con el id del elemento y el id criatura,
    //y si lo encuentra, lo elimina.
    public boolean delete(int idElemento, int idCriatura) {
        CriaturaElementoId criaturaElementoId = new CriaturaElementoId(idCriatura, idElemento);
        CriaturaElemento buscado = criaturaElementoRepository.findById(criaturaElementoId).orElse(null);
        if (buscado != null) {
            criaturaElementoRepository.delete(buscado);
            return true;
        } else {
            return false;
        }
    }
}
