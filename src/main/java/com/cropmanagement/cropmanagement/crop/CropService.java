package com.cropmanagement.cropmanagement.crop;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class CropService {
    public List<Crop> getCrops() {
        return List.of(
                new Crop(
                        1L,
                        "Tomato",
                        LocalDate.of(2023, Month.MARCH, 5)
                )
        );
    }
}
