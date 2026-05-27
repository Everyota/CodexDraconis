package com.example.habitat.Repository;

import com.example.habitat.Model.Habitat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HabitatRepository extends JpaRepository <Habitat, Integer> {
}
