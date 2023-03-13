package com.cropmanagement.cropmanagement.crop;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class CropConfig {

    @Bean
    CommandLineRunner commandLineRunner(CropRepository repository) {
        return args -> {
            Crop tomato = new Crop(
                    "Tomato",
                    LocalDate.of(2023, Month.MARCH, 5),
                    "tomb1234@hotmail.co.uk"
            );

            Crop pumpkin = new Crop(
                    "pumpkin",
                    LocalDate.of(2022, Month.AUGUST, 12),
                    "tomb123@hotmail.co.uk"
            );

            repository.saveAll(
                    List.of(tomato, pumpkin)
            );
        };
    }
}
