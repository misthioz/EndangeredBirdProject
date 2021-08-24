package com.example.endangered_birds_project.entity;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
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

    @Column(name = "mating_season")
    private String matingSeason;

    private int num_offspring;
    private int hatching_time;
    private String name;

    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "id")
    @NotNull
    private Species id;

    public ReproductionSpecies(int idReproduction, String matingSeason, int num_offspring, int hatching_time, Species id, String name) {
        this.idReproduction = idReproduction;
        this.matingSeason = matingSeason;
        this.num_offspring = num_offspring;
        this.hatching_time = hatching_time;
        this.id = id;
        this.name = name;
    }

    public ReproductionSpecies() {
    }
}
