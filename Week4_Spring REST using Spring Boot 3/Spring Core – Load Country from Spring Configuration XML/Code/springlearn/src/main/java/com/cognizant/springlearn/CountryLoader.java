package com.cognizant.springlearn;

import com.cognizant.model.Country;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CountryLoader implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(CountryLoader.class);
    private final Country country;

    public CountryLoader(Country country) {
        this.country = country;
    }

    @Override
    public void run(String... args) {
        log.info("Loaded bean from XML: {}", country);
    }
}