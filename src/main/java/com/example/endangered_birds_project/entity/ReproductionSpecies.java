package com.example.endangered_birds_project.entity;

import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
    Species id;
}
