package com.example.endangered_birds_project.request;

import com.example.endangered_birds_project.entity.Species;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SpeciesRequest {
    private int id;
    private String name;
    private String scientific_name;
    private String family;
    private String subfamily;
    private String tribe;
    private String habitat;
    private int num_wild;
    private int num_captive;

    public Species convert(){
        Species species = new Species();

        species.setName(this.name);
        species.setScientific_name(this.scientific_name);
        species.setFamily(this.family);
        species.setSubfamily(this.subfamily);
        species.setTribe(this.tribe);
        species.setHabitat(this.habitat);
        species.setNum_wild(this.num_wild);
        species.setNum_captive(this.num_captive);

        return species;
    }

    public Species convertAtualizar(int id){
        return new Species(id, name, scientific_name, family, subfamily, tribe, habitat, num_wild, num_captive);
    }

}
