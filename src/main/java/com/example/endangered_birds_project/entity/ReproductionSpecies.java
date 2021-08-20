package com.example.endangered_birds_project.entity;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name="species_reproduction")
public class ReproductionSpecies {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idReproduction;
    private String mating_season;
    private int num_offspring;
    private int hatching_time;

    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "id")
    @NotNull
    private Species id;

    public ReproductionSpecies(int idReproduction, String mating_season, int num_offspring, int hatching_time, Species id) {
        this.idReproduction = idReproduction;
        this.mating_season = mating_season;
        this.num_offspring = num_offspring;
        this.hatching_time = hatching_time;
        this.id = id;
    }

    public ReproductionSpecies() {
    }
}
