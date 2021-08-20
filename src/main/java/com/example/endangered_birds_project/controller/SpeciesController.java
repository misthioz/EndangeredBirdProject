package com.example.endangered_birds_project.controller;

import com.example.endangered_birds_project.entity.Species;
import com.example.endangered_birds_project.repository.SpeciesRepository;
import com.example.endangered_birds_project.request.SpeciesRequest;
import com.example.endangered_birds_project.response.SpeciesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class SpeciesController {
    @Autowired
    private SpeciesRepository speciesRepository;

//    @PostMapping
//    public ResponseEntity<SpeciesResponse> addSpecies(
//            @RequestBody SpeciesRequest speciesRequest,
//            UriComponentsBuilder uriComponentsBuilder){
//        Species species = speciesRequest.convert();
//        speciesRepository.save(species);
//    }
}
