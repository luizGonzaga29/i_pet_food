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

import com.acc.i_pet_food.models.Item;
import com.acc.i_pet_food.repositories.ItemRepository;

@RestController
public class ItemController {

	@Autowired
	private ItemRepository itemRepository;

	@RequestMapping(value = "/item", method = RequestMethod.GET)
	public ResponseEntity<List<Item>> listarClientes() {
		List<Item> itens = itemRepository.findAll();
		return ResponseEntity.ok().body(itens);
	}

	@RequestMapping(value = "/item/{id}", method = RequestMethod.GET)
	public ResponseEntity<Item> pegarItemId(@PathVariable(value = "id") int id) {
		Optional<Item> iten = itemRepository.findById(id);
		if (iten.isPresent())
			return new ResponseEntity<Item>(iten.get(), HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/item", method = RequestMethod.POST)
	public Item saveItem(@Valid @RequestBody Item item) {
		return itemRepository.save(item);
	}

	@RequestMapping(value = "/item/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Item> updateItem(@PathVariable(value = "id") int id,
			@Valid @RequestBody Item newItem) {
		Optional<Item> oldItem = itemRepository.findById(id);
		if (oldItem.isPresent()) {
			Item item = oldItem.get();
			
			
			itemRepository.save(item);
			return new ResponseEntity<Item>(item, HttpStatus.OK);
		} else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/item/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteItem(@PathVariable(value = "id") int id) {
		Optional<Item> item = itemRepository.findById(id);
		if (item.isPresent()) {
			itemRepository.delete(item.get());
			return new ResponseEntity<>(HttpStatus.OK);
		} else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
