package com.example.trainerApplication.repositories;

import com.example.trainerApplication.models.entities.TrainerType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainerTypeRepository extends JpaRepository<TrainerType,Long> {
    TrainerType findByTypeName(String typeName);

}
