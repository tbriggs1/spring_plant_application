package com.cropmanagement.cropmanagement.crop;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class Crop {

    @Id
    @SequenceGenerator(
            name = "crop_sequence",
            sequenceName = "crop_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "crop_sequence"
    )
    private Long id;
    private String cropName;
    private LocalDate planted;
    @Transient
    private Integer age;
    private String email;

    public Crop(){

    }

    public Crop(Long id, String cropName, LocalDate planted, String email){
        this.id = id;
        this.cropName = cropName;
        this. planted = planted;
        this.email = email;
    }

    public Crop(String cropName, LocalDate planted, String email) {
        this.cropName = cropName;
        this.planted = planted;
        this.email = email;
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

    public Integer getAge(){
        return Period.between(planted, LocalDate.now()).getDays();
    }

    public void setAge(Integer age){
        this.age = age;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }
}
