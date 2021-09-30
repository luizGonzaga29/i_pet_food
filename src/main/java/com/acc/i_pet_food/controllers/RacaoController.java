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

import com.acc.i_pet_food.models.Racao;
import com.acc.i_pet_food.repositories.RacaoRrepository;

@RestController
public class RacaoController {

	
	@Autowired
	private RacaoRrepository racaoRrepository;

	@RequestMapping(value = "/racao", method = RequestMethod.GET)
	public ResponseEntity<List<Racao>> listarRacoes() {
		List<Racao> racoes = racaoRrepository.findAll();
		return ResponseEntity.ok().body(racoes);
	}

	@RequestMapping(value = "/racao/{id}", method = RequestMethod.GET)
	public ResponseEntity<Racao> pegarRacaoId(@PathVariable(value = "id") int id) {
		Optional<Racao> racao = racaoRrepository.findById(id);
		if (racao.isPresent())
			return new ResponseEntity<Racao>(racao.get(), HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/racao", method = RequestMethod.POST)
	public Racao saveCliente(@Valid @RequestBody Racao racao) {
		return racaoRrepository.save(racao);
	}

	@RequestMapping(value = "/racao/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Racao> updateRacao(@PathVariable(value = "id") int id,
			@Valid @RequestBody Racao newRacao) {
		Optional<Racao> oldRacao = racaoRrepository.findById(id);
		if (oldRacao.isPresent()) {
			Racao racao = oldRacao.get();
			racao.setNome(newRacao.getNome());
			racao.setPreco(newRacao.getPreco());
			racao.setDesconto(newRacao.getDesconto());
			racaoRrepository.save(racao);
			return new ResponseEntity<Racao>(racao, HttpStatus.OK);
		} else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/racao/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteRacao(@PathVariable(value = "id") int id) {
		Optional<Racao> racao = racaoRrepository.findById(id);
		if (racao.isPresent()) {
			racaoRrepository.delete(racao.get());
			return new ResponseEntity<>(HttpStatus.OK);
		} else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
