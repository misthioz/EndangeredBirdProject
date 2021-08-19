package com.example.endangered_birds_project.response;

import com.example.endangered_birds_project.entity.Species;
import lombok.Getter;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class SpeciesResponse {
    @Getter private int id;
    @Getter private String name;
    @Getter private String scientific_name;
    @Getter private String family;
    @Getter private String subfamily;
    @Getter private String tribe;
    @Getter private String habitat;
    @Getter private int num_wild;
    @Getter private int num_captive;

    public SpeciesResponse(Species species){
        this.id = species.getId();
        this.name = species.getName();
        this.scientific_name = species.getScientific_name();
        this.family = species.getFamily();
        this.subfamily = species.getSubfamily();
        this.tribe = species.getTribe();
        this.habitat = species.getHabitat();
        this.num_wild = species.getNum_wild();
        this.num_captive = species.getNum_captive();
    }

    public List<SpeciesResponse> convert(List<Species> speciesList){
        return speciesList.stream().map(SpeciesResponse::new).collect(Collectors.toList());
    }
}
