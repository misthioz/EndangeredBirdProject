package com.example.endangered_birds_project.controller;

import com.example.endangered_birds_project.entity.Bird;
import com.example.endangered_birds_project.repository.BirdRepository;
import com.example.endangered_birds_project.request.BirdRequest;
import com.example.endangered_birds_project.response.BirdResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

    @GetMapping
    public List<BirdResponse> listBirds(){
        List<Bird> blist = birdRepository.findAll();
        return BirdResponse.convert(blist);
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

}
