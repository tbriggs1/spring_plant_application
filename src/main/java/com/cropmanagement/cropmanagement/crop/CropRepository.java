package com.cropmanagement.cropmanagement.crop;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CropRepository extends JpaRepository<Crop,Long> {

    @Query("Select c From Crop c WHERE c.email = ?1")
    Optional<Crop> findCropByEmail(String email);
}
