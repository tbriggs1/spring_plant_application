package com.cropmanagement.cropmanagement.crop;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

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

    public void addNewCrop(Crop crop) {
        Optional<Crop> cropOptional = cropRepository.findCropByEmail(crop.getEmail());
        if (cropOptional.isPresent()){
            throw new IllegalStateException("email taken");
        }
        cropRepository.save(crop);
    }

    public void deleteCrop(Long cropId){
        boolean exists = cropRepository.existsById(cropId);

        if (!exists){
            throw new IllegalStateException("student with id " + cropId + " does not exist");
        }
        cropRepository.deleteById(cropId);
    }

    @Transactional
    public void updateCrop(Long cropId, String cropName, String email){
        Crop crop = cropRepository.findById(cropId).orElseThrow(() -> new IllegalStateException("Crop with id " + cropId + " Does not exist" ));

        if (cropName != null && cropName.length() > 0 && !Objects.equals(crop.getCropName(), cropName)){
            crop.setCropName(cropName);
        }

        if (email != null && email.length() > 0 && !Objects.equals(crop.getEmail(), email)){
            crop.setEmail(email);
        }
    }


}
