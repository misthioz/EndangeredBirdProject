package com.example.endangered_birds_project.request;

import com.example.endangered_birds_project.entity.ReproductionSpecies;
import com.example.endangered_birds_project.repository.SpeciesRepository;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReproductionSpeciesRequest {
    SpeciesRepository speciesRepository;
    private int id_reproduction;
    private int id;
    private String matingSeason;
    private String name;
    private int num_offspring;
    private int hatching_time;

    public ReproductionSpecies convert(){
        ReproductionSpecies reproductionSpecies = new ReproductionSpecies();

        reproductionSpecies.setIdReproduction(id_reproduction);
        reproductionSpecies.setId(speciesRepository.getById(id_reproduction));
        reproductionSpecies.setMatingSeason(this.matingSeason);
        reproductionSpecies.setNum_offspring(this.num_offspring);
        reproductionSpecies.setHatching_time(this.hatching_time);
        reproductionSpecies.setName(this.name);

        return reproductionSpecies;
    }

    public ReproductionSpecies convertAtualiza(int id_reproduction){
        return new ReproductionSpecies(id_reproduction, matingSeason,num_offspring,hatching_time,speciesRepository.getById(id_reproduction), name);
    }
}
