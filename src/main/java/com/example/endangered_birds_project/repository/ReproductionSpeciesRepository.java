package com.example.endangered_birds_project.repository;

import com.example.endangered_birds_project.entity.ReproductionSpecies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReproductionSpeciesRepository extends JpaRepository<ReproductionSpecies, Integer> {

}
