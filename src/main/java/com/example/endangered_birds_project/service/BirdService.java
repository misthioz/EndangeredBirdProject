package com.example.endangered_birds_project.service;

import com.example.endangered_birds_project.controller.SpeciesController;
import com.example.endangered_birds_project.entity.Bird;
import com.example.endangered_birds_project.entity.Species;
import com.example.endangered_birds_project.repository.BirdRepository;
import com.example.endangered_birds_project.repository.SpeciesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class BirdService {
    private BirdRepository birdRepository;
    private SpeciesRepository speciesRepository;

    public boolean checkIfSpeciesExist(Species species){
        List<Species> speciesList = speciesRepository.findAll();
        for(Species sp : speciesList){
            if(sp.getId() == species.getId()){
                changeNumSpecies(species);
                return true;
            }
        }
        return false;
    }

    public void changeNumSpecies(Species species){
        int newNum = species.getNum_captive();
        species.setNum_captive(newNum+1);
    }

}
