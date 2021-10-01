package com.acc.i_pet_food.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acc.i_pet_food.models.Item;

public interface ItemRepository extends JpaRepository<Item, Integer>{

}
