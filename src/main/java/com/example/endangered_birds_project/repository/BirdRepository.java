package com.example.endangered_birds_project.repository;

import com.example.endangered_birds_project.entity.Bird;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BirdRepository extends JpaRepository<Bird, Integer> {
    List<Bird> findBySpecies_name(String species_name);
    List<Bird> findByNickname(String nickname);
}
