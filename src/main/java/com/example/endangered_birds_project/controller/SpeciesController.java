package com.example.endangered_birds_project.controller;

import com.example.endangered_birds_project.entity.Species;
import com.example.endangered_birds_project.repository.SpeciesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpeciesController {
    @Autowired
    private SpeciesRepository speciesRepository;

    @RequestMapping("/specieslist")
    public Iterable<Species> listSpecies(){
        return speciesRepository.findAll();
    }
}
