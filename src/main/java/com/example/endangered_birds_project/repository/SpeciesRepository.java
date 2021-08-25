package com.example.endangered_birds_project.repository;

import com.example.endangered_birds_project.entity.Species;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpeciesRepository extends JpaRepository<Species, Integer> {
    List<Species> findByName(String name);
    List<Species> findByHabitat(String habitat);
    List<Species> findById(int id);
}
