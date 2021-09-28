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

import com.acc.i_pet_food.models.Compra;
import com.acc.i_pet_food.repositories.CompraRepository;

@RestController
public class CompraController {

	@Autowired
	private CompraRepository compraRepository;

	@RequestMapping(value = "/compra", method = RequestMethod.GET)
	public ResponseEntity<List<Compra>> listarCompras() {
		List<Compra> compra = compraRepository.findAll();
		return ResponseEntity.ok().body(compra);
	}

	@RequestMapping(value = "/compra/{id}", method = RequestMethod.GET)
	public ResponseEntity<Compra> pegarCompraId(@PathVariable(value = "id") int id) {
		Optional<Compra> compra = compraRepository.findById(id);
		if (compra.isPresent())
			return new ResponseEntity<Compra>(compra.get(), HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/compra", method = RequestMethod.POST)
	public Compra saveCompra(@Valid @RequestBody Compra compra) {
		return compraRepository.save(compra);
	}

//	@RequestMapping(value = "/compra/{id}", method = RequestMethod.PUT)
//	public ResponseEntity<Compra> updateCliente(@PathVariable(value = "id") int id,
//			@Valid @RequestBody Compra newCompra) {
//		Optional<Compra> oldCompra = compraRepository.findById(id);
//		if (oldCompra.isPresent()) {
//			Compra compra = oldCompra.get();
//			compra.setNome(newCompra.getNome());
//			compraRepository.save(compra);
//			return new ResponseEntity<Compra>(compra, HttpStatus.OK);
//		} else
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//	}

	@RequestMapping(value = "/compra/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteCliente(@PathVariable(value = "id") int id) {
		Optional<Compra> compra = compraRepository.findById(id);
		if (compra.isPresent()) {
			compraRepository.delete(compra.get());
			return new ResponseEntity<>(HttpStatus.OK);
		} else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
}
