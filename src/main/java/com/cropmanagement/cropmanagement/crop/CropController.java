package com.cropmanagement.cropmanagement.crop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/crop")
public class CropController {

    private final CropService cropService;

    @Autowired
    public CropController(CropService cropService){
        this.cropService = cropService;
    }

    @GetMapping
    public List<Crop> getCrops() {
        return cropService.getCrops();
    }
}
