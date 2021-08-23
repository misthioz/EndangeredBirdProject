package com.example.endangered_birds_project.controller;

import com.example.endangered_birds_project.entity.Bird;
import com.example.endangered_birds_project.repository.BirdRepository;
import com.example.endangered_birds_project.request.BirdRequest;
import com.example.endangered_birds_project.response.BirdResponse;
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
@RequestMapping("/bird")
public class BirdController {
    @Autowired
    private BirdRepository birdRepository;

    @GetMapping("/list")
    public List<BirdResponse> listBirds(){
        List<Bird> blist = birdRepository.findAll();
        return BirdResponse.convert(blist);
    }

    @GetMapping("/{id}")
    public BirdResponse findBirdById(@PathVariable int id){
        Bird bird = birdRepository.getById(id);
        return new BirdResponse(bird);
    }

    @GetMapping("/findSpecies/{species_name}")
    public ResponseEntity<?> findBySpeciesName(@PathVariable String species_name){
        List<Bird> birds = birdRepository.findBySpecies_name(species_name);
        if(birds.size()>0){
            return ResponseEntity.ok().body(BirdResponse.convert(birds));
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Species not found. Provided species name: "+species_name);
        }
    }

    @GetMapping("/findNickname/{nickname}")
    public ResponseEntity<?> findBirdByNickname(@PathVariable String nickname){
        List<Bird> birds = birdRepository.findByNickname(nickname);
        if(birds.size()>0){
            return ResponseEntity.ok().body(BirdResponse.convert(birds));
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Bird not found. Provided nickname: "+nickname);
        }
    }

    @PostMapping
    public ResponseEntity<BirdResponse> addBird(
            @RequestBody BirdRequest birdRequest,
            UriComponentsBuilder uriComponentsBuilder){
        Bird bird = birdRequest.convert();
        birdRepository.save(bird);

        URI uri = uriComponentsBuilder.path("/bird/{id}").buildAndExpand(bird.getBird_id()).toUri();
        return ResponseEntity.created(uri).body(new BirdResponse(bird));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BirdResponse> edit(@PathVariable int id, @RequestBody BirdRequest birdRequest){
        Bird bird = birdRequest.convertAtualiza(id);
        birdRepository.save(bird);

        return ResponseEntity.ok(new BirdResponse(bird));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id){
        birdRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
