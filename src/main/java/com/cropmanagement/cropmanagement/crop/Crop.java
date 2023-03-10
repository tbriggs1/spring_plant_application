package com.cropmanagement.cropmanagement.crop;

import java.time.LocalDate;

public class Crop {
    private Long id;
    private String cropName;
    private LocalDate planted;

    public Crop(){

    }

    public Crop(Long id, String cropName, LocalDate planted){
        this.id = id;
        this.cropName = cropName;
        this. planted = planted;
    }

    public Crop(String cropName, LocalDate planted) {
        this.cropName = cropName;
        this.planted = planted;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getCropName(){
        return cropName;
    }

    public void setCropName(String cropName){
        this.cropName = cropName;
    }

    public LocalDate getPlanted(){
        return planted;
    }

    public void setPlanted(LocalDate planted){
        this.planted = planted;
    }
}
