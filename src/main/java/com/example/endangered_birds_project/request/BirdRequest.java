package com.example.endangered_birds_project.request;

import com.example.endangered_birds_project.entity.Bird;
import com.example.endangered_birds_project.repository.SpeciesRepository;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class BirdRequest {
    SpeciesRepository speciesRepository;
    private int bird_id;
    private int species_id;
    private String speciesName;
    private String nickname;
    private char sex;
    private LocalDate date_of_birth;

    public Bird convert(){
        Bird bird = new Bird();
        bird.setSpeciesName(this.speciesName);
        bird.setSpecie_id(speciesRepository.getById(species_id));
        bird.setNickname(this.nickname);
        bird.setSex(this.sex);
        bird.setDate_of_birth(this.date_of_birth);

        return bird;
    }

    public Bird convertAtualiza(int id){

        return new Bird(id,speciesRepository.getById(species_id), speciesName,nickname,sex,date_of_birth);
    }
}
