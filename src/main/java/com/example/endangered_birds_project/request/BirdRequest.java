package com.example.endangered_birds_project.request;

import com.example.endangered_birds_project.entity.Bird;
import com.example.endangered_birds_project.entity.Species;
import com.example.endangered_birds_project.repository.SpeciesRepository;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Optional;

@Getter
@Setter
public class BirdRequest {
    SpeciesRepository speciesRepository;
    private int bird_id;
    private int species_id;
    private String species_name;
    private String nickname;
    private char sex;
    private LocalDate date_of_birth;

    public Bird convert(){
        Bird bird = new Bird();
        Optional<Species> speciesOptional = speciesRepository.findById(species_id);
        Species species = speciesOptional.get();
        bird.setSpecie_id(species);
        bird.setSpecies_name(species.getName());
        bird.setNickname(this.nickname);
        bird.setSex(this.sex);
        bird.setDate_of_birth(this.date_of_birth);

        return bird;
    }

    public Bird convertAtualiza(int id){
        Optional<Species> speciesOptional = speciesRepository.findById(species_id);
        Species species = speciesOptional.get();
        return new Bird(id,species, species.getName(),nickname,sex,date_of_birth);
    }
}
