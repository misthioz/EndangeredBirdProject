package com.example.endangered_birds_project.controller;

import com.example.endangered_birds_project.entity.Species;
import com.example.endangered_birds_project.repository.SpeciesRepository;
import com.example.endangered_birds_project.request.SpeciesRequest;
import com.example.endangered_birds_project.response.SpeciesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/species")
public class SpeciesController {
    @Autowired
    private SpeciesRepository speciesRepository;

    @GetMapping("/list")
    public List<SpeciesResponse> listSpecies(){
        List<Species> speciesList = speciesRepository.findAll();
        return SpeciesResponse.convert(speciesList);
    }

//    @PostMapping
//    public ResponseEntity<SpeciesResponse> addSpecies(
//            @RequestBody SpeciesRequest speciesRequest,
//            UriComponentsBuilder uriComponentsBuilder){
//        Species species = speciesRequest.convert();
//        speciesRepository.save(species);
//    }
}
