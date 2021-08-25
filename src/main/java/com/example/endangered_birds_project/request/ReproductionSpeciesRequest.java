package com.example.endangered_birds_project.request;

import com.example.endangered_birds_project.entity.ReproductionSpecies;
import com.example.endangered_birds_project.entity.Species;
import com.example.endangered_birds_project.repository.SpeciesRepository;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReproductionSpeciesRequest {
    private int id;
    private String matingSeason;
    private String name;
    private int num_offspring;
    private int hatching_time;

    public ReproductionSpecies convert(Species species){
        ReproductionSpecies reproductionSpecies = new ReproductionSpecies();

        reproductionSpecies.setId(species);
        reproductionSpecies.setMatingSeason(this.matingSeason);
        reproductionSpecies.setNum_offspring(this.num_offspring);
        reproductionSpecies.setHatching_time(this.hatching_time);
        reproductionSpecies.setName(this.name);

        return reproductionSpecies;
    }

    public ReproductionSpecies convertAtualiza(int id_reproduction, Species species){
        return new ReproductionSpecies(id_reproduction, matingSeason,num_offspring,hatching_time,species, name);
    }
}
