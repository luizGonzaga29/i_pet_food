package com.acc.i_pet_food.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acc.i_pet_food.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, String> {

}
