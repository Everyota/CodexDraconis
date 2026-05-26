package com.duoc.favorito.Repository;

import com.duoc.favorito.Model.Favorito;
import com.duoc.favorito.Model.FavoritoId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavoritoRepository extends JpaRepository<Favorito, FavoritoId> {
//Encuentra los favoritos que ha marcado un usuario
    List<Favorito> findByIdIdUsuario(Long idUsuario);
//Retorna cada Id de persona que tiene como favorita esa criatura
    List<Favorito> findByIdIdCriatura(Long idCriatura);
}

