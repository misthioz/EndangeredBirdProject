package com.example.endangered_birds_project.response;

import com.example.endangered_birds_project.entity.ReproductionSpecies;
import com.example.endangered_birds_project.repository.SpeciesRepository;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

public class ReproductionSpeciesResponse {
    private SpeciesRepository speciesRepository;
    @Getter private int id_species;
    @Getter private int id_reproduction;
    @Getter private String matingSeason;
    @Getter private int num_offspring;
    @Getter private int hatching_time;
    @Getter private String name;

    public ReproductionSpeciesResponse(ReproductionSpecies reproductionSpecies){
        this.id_reproduction = reproductionSpecies.getIdReproduction();
        this.id_species = speciesRepository.getById(id_reproduction).getId();
        this.matingSeason = reproductionSpecies.getMatingSeason();
        this.num_offspring = reproductionSpecies.getNum_offspring();
        this.hatching_time = reproductionSpecies.getHatching_time();
        this.name = reproductionSpecies.getName();
    }

    public static List<ReproductionSpeciesResponse> convert(List<ReproductionSpecies> replist){
        return replist.stream().map(ReproductionSpeciesResponse::new).collect(Collectors.toList());
    }
}
