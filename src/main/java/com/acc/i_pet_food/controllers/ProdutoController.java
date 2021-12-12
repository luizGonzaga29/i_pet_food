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

import com.acc.i_pet_food.models.Pet;
import com.acc.i_pet_food.models.Produto;
import com.acc.i_pet_food.repositories.ProdutoRepository;

@RestController
public class ProdutoController {

	@Autowired
	private ProdutoRepository produtoRepository;

	@RequestMapping(value = "/produto", method = RequestMethod.GET)
	public ResponseEntity<List<Produto>> listarProdutos() {
		List<Produto> produto = produtoRepository.findAll();
		return ResponseEntity.ok().body(produto);
	}

	@RequestMapping(value = "/produto/{id}", method = RequestMethod.GET)
	public ResponseEntity<Produto> pegarProdutoId(@PathVariable(value = "id") int id) {
		Optional<Produto> produto = produtoRepository.findById(id);
		if (produto.isPresent())
			return new ResponseEntity<Produto>(produto.get(), HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/produto", method = RequestMethod.POST)
	public Produto saveProduto(@Valid @RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}


	@RequestMapping(value = "/produto/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteProduto(@PathVariable(value = "id") int id) {
		Optional<Produto> produto = produtoRepository.findById(id);
		if (produto.isPresent()) {
			produtoRepository.delete(produto.get());
			return new ResponseEntity<>(HttpStatus.OK);
		} else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value = "/produto/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Produto> updateProduto(@PathVariable(value = "id") int id,
			@Valid @RequestBody Produto newProduto) {
		Optional<Produto> oldProduto = produtoRepository.findById(id);
		if (oldProduto.isPresent()) {
			Produto produto = oldProduto.get();
			produto.setNome(newProduto.getNome());
			produto.setDescricao(newProduto.getDescricao());
			produto.setPreco(newProduto.getPreco());
			produtoRepository.save(produto);
			return new ResponseEntity<Produto>(produto, HttpStatus.OK);
		} else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
}
