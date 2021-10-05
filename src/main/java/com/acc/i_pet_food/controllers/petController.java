package com.acc.i_pet_food.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.acc.i_pet_food.models.Pet;
import com.acc.i_pet_food.repositories.PetRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class petController {

	@Autowired
	private PetRepository petRepository;

	@RequestMapping(value = "/pet", method = RequestMethod.GET)
	public ResponseEntity<List<Pet>> listarClientes() {
		List<Pet> pets = petRepository.findAll();
		return ResponseEntity.ok().body(pets);
	}

	@RequestMapping(value = "/pet/{id}", method = RequestMethod.GET)
	public ResponseEntity<Pet> pegarPetId(@PathVariable(value = "id") int id) {
		Optional<Pet> pet = petRepository.findById(id);
		if (pet.isPresent())
			return new ResponseEntity<Pet>(pet.get(), HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/pet", method = RequestMethod.POST)
	public Pet saveCliente(@Valid @RequestBody Pet pet) {
		return petRepository.save(pet);
	}

	@RequestMapping(value = "/pet/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Pet> updatePet(@PathVariable(value = "id") int id,
			@Valid @RequestBody Pet newPet) {
		Optional<Pet> oldPet = petRepository.findById(id);
		if (oldPet.isPresent()) {
			Pet pet = oldPet.get();
			pet.setNome(newPet.getNome());
			pet.setPeso(newPet.getPeso());
			
			petRepository.save(pet);
			return new ResponseEntity<Pet>(pet, HttpStatus.OK);
		} else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/pet/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deletePet(@PathVariable(value = "id") int id) {
		Optional<Pet> pet = petRepository.findById(id);
		if (pet.isPresent()) {
			petRepository.delete(pet.get());
			return new ResponseEntity<>(HttpStatus.OK);
		} else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
