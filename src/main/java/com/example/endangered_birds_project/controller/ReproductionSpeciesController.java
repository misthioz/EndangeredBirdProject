package com.example.endangered_birds_project.controller;

import com.example.endangered_birds_project.entity.ReproductionSpecies;
import com.example.endangered_birds_project.repository.ReproductionSpeciesRepository;
import com.example.endangered_birds_project.request.ReproductionSpeciesRequest;
import com.example.endangered_birds_project.response.ReproductionSpeciesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/reproduction")
public class ReproductionSpeciesController {

    private ReproductionSpeciesRepository reproductionSpeciesRepository;

    @PostMapping
    public ResponseEntity<ReproductionSpeciesResponse> addReproductionSpecies(
            @RequestBody ReproductionSpeciesRequest reproductionSpeciesRequest,
            UriComponentsBuilder uriComponentsBuilder){
        ReproductionSpecies reproductionSpecies = reproductionSpeciesRequest.convert();
        reproductionSpeciesRepository.save(reproductionSpecies);
        URI uri = uriComponentsBuilder.path("/reproduction/{id}")
                .buildAndExpand(reproductionSpecies.getIdReproduction()).toUri();
        return ResponseEntity.created(uri).body(new ReproductionSpeciesResponse(reproductionSpecies));
    }
}
