package com.cropmanagement.cropmanagement.crop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public void addCrop(@RequestBody Crop crop){
        cropService.addNewCrop(crop);
    }

    @DeleteMapping(path = "{cropId}")
    public void deleteCrop(@PathVariable("cropId") Long cropId){
        cropService.deleteCrop(cropId);
    }

    @PutMapping(path = "{cropId}")
    public void updateCrop(
            @PathVariable("cropId") Long cropId,
            @RequestParam(required = false) String cropName,
            @RequestParam(required = false) String email){
        cropService.updateCrop(cropId, cropName, email);
    }
}
