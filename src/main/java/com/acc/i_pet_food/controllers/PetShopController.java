package com.acc.i_pet_food.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.acc.i_pet_food.models.PetShop;
import com.acc.i_pet_food.repositories.PetShopRepository;

@RestController
public class PetShopController {

	
	@Autowired
	private PetShopRepository petShopRepository;

	@RequestMapping(value = "/petshop", method = RequestMethod.GET)
	public ResponseEntity<List<PetShop>> listarPetShop() {
		List<PetShop> petShop = petShopRepository.findAll();
		return ResponseEntity.ok().body(petShop);
	}

	@RequestMapping(value = "/petshop/{id}", method = RequestMethod.GET)
	public ResponseEntity<PetShop> pegarPetShopCnpj(@PathVariable(value = "id") String cnpj) {
		Optional<PetShop> petShop = petShopRepository.findById(cnpj);
		if (petShop.isPresent())
			return new ResponseEntity<PetShop>(petShop.get(), HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/petshop", method = RequestMethod.POST)
	public PetShop savePetShop(@Valid @RequestBody PetShop petShop) {
		return petShopRepository.save(petShop);
	}

	@RequestMapping(value = "/petshop/{id}", method = RequestMethod.PUT)
	public ResponseEntity<PetShop> updatePetShop(@PathVariable(value = "id") String cnpj,
			@Valid @RequestBody PetShop newPetShop) {
		Optional<PetShop> oldPetShop = petShopRepository.findById(cnpj);
		if (oldPetShop.isPresent()) {
			PetShop petShop = oldPetShop.get();
			petShop.setRazaoSocial(newPetShop.getRazaoSocial());
			petShop.setNomeFantasia(newPetShop.getNomeFantasia());
			petShop.setEmail(newPetShop.getEmail());
			petShop.setNomeResponsavel(newPetShop.getNomeResponsavel());
			
			petShopRepository.save(petShop);
			return new ResponseEntity<PetShop>(petShop, HttpStatus.OK);
		} else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/petshop/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deletePetShop(@PathVariable(value = "id") String cnpj) {
		Optional<PetShop> petShop = petShopRepository.findById(cnpj);
		if (petShop.isPresent()) {
			petShopRepository.delete(petShop.get());
			return new ResponseEntity<>(HttpStatus.OK);
		} else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
