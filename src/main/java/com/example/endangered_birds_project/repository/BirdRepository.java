package com.example.endangered_birds_project.repository;

import com.example.endangered_birds_project.entity.Bird;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BirdRepository extends JpaRepository<Bird, Integer> {
}
