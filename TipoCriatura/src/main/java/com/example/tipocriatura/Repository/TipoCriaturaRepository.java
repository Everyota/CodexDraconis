package com.example.tipocriatura.Repository;

import com.example.tipocriatura.Model.TipoCriatura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoCriaturaRepository extends JpaRepository <TipoCriatura, Integer> {
}
