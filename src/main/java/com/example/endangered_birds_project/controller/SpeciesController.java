package com.example.endangered_birds_project.controller;

import com.example.endangered_birds_project.entity.Species;
import com.example.endangered_birds_project.repository.SpeciesRepository;
import com.example.endangered_birds_project.request.SpeciesRequest;
import com.example.endangered_birds_project.response.SpeciesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
@RequestMapping("/species")
public class SpeciesController {
    @Autowired
    private SpeciesRepository speciesRepository;

    @GetMapping("/list")
    public List<SpeciesResponse> listSpecies(){
        List<Species> speciesList = speciesRepository.findAll();
        return SpeciesResponse.convert(speciesList);
    }

    @GetMapping("/{id}")
    public SpeciesResponse findSpeciesById(@PathVariable int id){
        Species species = speciesRepository.getById(id);
        return new SpeciesResponse(species);
    }

    @GetMapping("/findName/{name}")
    public ResponseEntity<?> findSpeciesByName(@PathVariable String name){
        List<Species> lspecies = speciesRepository.findByName(name);
        if(lspecies.size()>0){
            return ResponseEntity.ok().body(SpeciesResponse.convert(lspecies));
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Name not found. Provided name: "+name);
        }
    }

    @GetMapping("/findHabitat/{habitat}")
    public ResponseEntity<?> findSpeciesByHabitat(@PathVariable String habitat){
        List<Species> lspecies = speciesRepository.findByHabitat(habitat);
        if(lspecies.size()>0){
            return ResponseEntity.ok().body(SpeciesResponse.convert(lspecies));
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Habitat not found. Provided name: "+habitat);
        }
    }




    @PostMapping
    public ResponseEntity<SpeciesResponse> addSpecies(
            @RequestBody SpeciesRequest speciesRequest,
            UriComponentsBuilder uriComponentsBuilder){
        Species species = speciesRequest.convert();
        speciesRepository.save(species);

        URI uri = uriComponentsBuilder.path("/species/{id}").buildAndExpand(species.getId()).toUri();
        return ResponseEntity.created(uri).body(new SpeciesResponse(species));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SpeciesResponse> edit(@PathVariable int id,
                                                @RequestBody SpeciesRequest speciesRequest){
        Species species = speciesRequest.convertAtualizar(id);
        speciesRepository.save(species);
        return ResponseEntity.ok(new SpeciesResponse(species));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id){
        speciesRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
