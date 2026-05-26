package com.duoc.favorito.Service;

import com.duoc.favorito.Model.Favorito;
import com.duoc.favorito.Model.FavoritoId;
import com.duoc.favorito.Repository.FavoritoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class FavoritoService {
    @Autowired
    private FavoritoRepository favoritoRepository;

    public List<Favorito> findAll(){
        return favoritoRepository.findAll();
    }

    public List<Favorito> findByCriatura(Long idCriatura){
        return favoritoRepository.findByIdIdCriatura(idCriatura);
    }

    public List<Favorito> findByUsuario(Long idUsuario){
        return favoritoRepository.findByIdIdUsuario(idUsuario);
    }

    public Favorito create(Favorito favorito){
        return favoritoRepository.save(favorito);
    }


    //Buscado es el favorito que coincide con el id del usuario y el id criatura. Es decir,
    //es el favorito del usuario con la criatura, y si lo encuentra, lo elimina.
    public boolean delete(int idUsuario, int idCriatura) {
        FavoritoId favoritoId = new FavoritoId(idUsuario, idCriatura);
        Favorito buscado = favoritoRepository.findById(favoritoId).orElse(null);
        if (buscado != null) {
            favoritoRepository.delete(buscado);
            return true;
        } else {
            return false;
        }
    }
}
