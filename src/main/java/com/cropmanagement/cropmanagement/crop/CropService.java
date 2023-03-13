package com.cropmanagement.cropmanagement.crop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CropService {

    private final CropRepository cropRepository;

    @Autowired
    public CropService(CropRepository cropRepository){
        this.cropRepository = cropRepository;
    }


    public List<Crop> getCrops() {
        return cropRepository.findAll();
    }
}
