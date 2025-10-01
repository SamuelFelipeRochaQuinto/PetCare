package com.petcare.PetCare.Repository;

import com.petcare.PetCare.Model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<Animal,Long> {
}
