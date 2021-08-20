package com.example.endangered_birds_project.request;

import com.example.endangered_birds_project.entity.ReproductionSpecies;
import com.example.endangered_birds_project.entity.Species;
import com.example.endangered_birds_project.repository.SpeciesRepository;
import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

@Getter
@Setter
public class ReproductionSpeciesRequest {
    SpeciesRepository speciesRepository;
    private int id_reproduction;
    private int id;
    private String mating_season;
    private int num_offspring;
    private int hatching_time;

    public ReproductionSpecies convert(){
        ReproductionSpecies reproductionSpecies = new ReproductionSpecies();

        Optional<Species> speciesOptional = speciesRepository.findById(id);
        Species species = speciesOptional.get();
        reproductionSpecies.setId(species);
        reproductionSpecies.setMating_season(this.mating_season);
        reproductionSpecies.setNum_offspring(this.num_offspring);
        reproductionSpecies.setHatching_time(this.hatching_time);

        return reproductionSpecies;
    }

    public ReproductionSpecies convertAtualiza(int id_reproduction){
        Optional<Species> speciesOptional = speciesRepository.findById(id);
        Species species = speciesOptional.get();
        return new ReproductionSpecies(id_reproduction,mating_season,num_offspring,hatching_time,species);
    }
}
