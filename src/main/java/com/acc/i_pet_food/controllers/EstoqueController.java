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

import com.acc.i_pet_food.models.Estoque;
import com.acc.i_pet_food.repositories.EstoqueRepository;

@RestController
public class EstoqueController {

	@Autowired
	private EstoqueRepository estoqueRepository;

	@RequestMapping(value = "/estoque", method = RequestMethod.GET)
	public ResponseEntity<List<Estoque>> listarEstoques() {
		List<Estoque> estoques = estoqueRepository.findAll();
		return ResponseEntity.ok().body(estoques);
	}

	@RequestMapping(value = "/estoque/{id}", method = RequestMethod.GET)
	public ResponseEntity<Estoque> pegarEstoqueId(@PathVariable(value = "id") int id) {
		Optional<Estoque> estoque = estoqueRepository.findById(id);
		if (estoque.isPresent())
			return new ResponseEntity<Estoque>(estoque.get(), HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/estoque", method = RequestMethod.POST)
	public Estoque saveEstoque(@Valid @RequestBody Estoque estoque) {
		return estoqueRepository.save(estoque);
	}

	@RequestMapping(value = "/estoque/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Estoque> updateEstoque(@PathVariable(value = "id") int id,
			@Valid @RequestBody Estoque newEstoque) {
		Optional<Estoque> oldEstoque = estoqueRepository.findById(id);
		if (oldEstoque.isPresent()) {
			Estoque estoque = oldEstoque.get();
			estoque.setNomeFabricante(newEstoque.getNomeFabricante());
			estoqueRepository.save(estoque);
			return new ResponseEntity<Estoque>(estoque, HttpStatus.OK);
		} else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/estoque/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteEstoque(@PathVariable(value = "id") int id) {
		Optional<Estoque> estoque = estoqueRepository.findById(id);
		if (estoque.isPresent()) {
			estoqueRepository.delete(estoque.get());
			return new ResponseEntity<>(HttpStatus.OK);
		} else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
