package com.acc.i_pet_food.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acc.i_pet_food.models.Pet;

public interface PetRepository extends JpaRepository<Pet, Integer> {
	
}
