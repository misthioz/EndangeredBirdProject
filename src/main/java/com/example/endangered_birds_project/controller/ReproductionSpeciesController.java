package com.example.endangered_birds_project.controller;

import com.example.endangered_birds_project.entity.ReproductionSpecies;
import com.example.endangered_birds_project.repository.ReproductionSpeciesRepository;
import com.example.endangered_birds_project.repository.SpeciesRepository;
import com.example.endangered_birds_project.request.ReproductionSpeciesRequest;
import com.example.endangered_birds_project.response.ReproductionSpeciesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/reproduction")
public class ReproductionSpeciesController {
    @Autowired
    private ReproductionSpeciesRepository reproductionSpeciesRepository;

    @GetMapping("/list")
    public List<ReproductionSpeciesResponse> listReproductionSpecies(){
        List<ReproductionSpecies> rslist = reproductionSpeciesRepository.findAll();
        return ReproductionSpeciesResponse.convert(rslist);
    }

    @GetMapping("/{id}")
    public ReproductionSpeciesResponse findRepSpeciesById(@PathVariable int id){
        ReproductionSpecies reproductionSpecies = reproductionSpeciesRepository.getById(id);
        return new ReproductionSpeciesResponse(reproductionSpecies);
    }

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

    @PutMapping("/{id}")
    public ResponseEntity<ReproductionSpeciesResponse> edit(
            @PathVariable int id, @RequestBody ReproductionSpeciesRequest reproductionSpeciesRequest){
        ReproductionSpecies reproductionSpecies = reproductionSpeciesRequest.convertAtualiza(id);
        reproductionSpeciesRepository.save(reproductionSpecies);

        return ResponseEntity.ok(new ReproductionSpeciesResponse(reproductionSpecies));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id){
        reproductionSpeciesRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
