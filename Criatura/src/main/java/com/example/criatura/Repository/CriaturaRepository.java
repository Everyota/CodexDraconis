package com.example.criatura.Repository;

import com.example.criatura.Model.Criatura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CriaturaRepository extends JpaRepository <Criatura, Integer> {
    List<Criatura> findByIdTipoCriatura(Integer idTipoCriatura);

    List<Criatura> findByIdRareza(Integer idRareza);

}
