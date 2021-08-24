package com.example.endangered_birds_project.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="bird")
public class Bird {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bird_id;

    @OneToOne
    @JoinColumn(name = "species_id", referencedColumnName = "id")
    @NotNull
    private Species specie_id;

    private String speciesName;
    private String nickname;
    private char sex;
    private LocalDate date_of_birth;

}
