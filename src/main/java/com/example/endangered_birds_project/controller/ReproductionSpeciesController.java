package com.example.endangered_birds_project.controller;

import com.example.endangered_birds_project.repository.ReproductionSpeciesRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReproductionSpeciesController {

    private ReproductionSpeciesRepository reproductionSpeciesRepository;
}
