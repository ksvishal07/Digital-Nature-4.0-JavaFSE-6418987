package com.cognizant.spring_learn.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/countries")
public class CountryController {

    @GetMapping
    public List<String> getCountries() {
        return List.of("India", "USA", "Germany", "Japan");
    }
}
