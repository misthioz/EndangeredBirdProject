package com.example.endangered_birds_project.response;

import com.example.endangered_birds_project.entity.Bird;
import com.example.endangered_birds_project.repository.SpeciesRepository;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class BirdResponse {
    private SpeciesRepository speciesRepository;
    @Getter private int bird_id;
    @Getter private int species_id;
    @Getter String species_name;
    @Getter String nickname;
    @Getter char sex;
    @Getter LocalDate date_of_birth;

    public BirdResponse(Bird bird){
        this.bird_id = bird.getBird_id();
        this.species_id = speciesRepository.getById(species_id).getId();
        this.species_name = bird.getSpecies_name();
        this.nickname = bird.getNickname();
        this.sex = bird.getSex();
        this.date_of_birth = getDate_of_birth();
    }

    public List<BirdResponse> convert(List<Bird> birds){
        return birds.stream().map(BirdResponse::new).collect(Collectors.toList());
    }
}
