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

import com.acc.i_pet_food.exeption.ClienteException;
import com.acc.i_pet_food.models.Cliente;
import com.acc.i_pet_food.repositories.ClienteRepository;
import com.acc.i_pet_food.util.ClienteUtil;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;
    private ClienteUtil clienteUtil = new ClienteUtil();
	
	@RequestMapping(value = "/cliente", method = RequestMethod.GET)
	public ResponseEntity<List<Cliente>> listarClientes() {
		List<Cliente> clientes = clienteRepository.findAll();
		return ResponseEntity.ok().body(clientes);
	}

	@RequestMapping(value = "/cliente/{id}", method = RequestMethod.GET)
	public ResponseEntity<Cliente> pegarClienteCpf(@PathVariable(value = "id") String cpf) {
		Optional<Cliente> cliente = clienteRepository.findById(cpf);

		if (cliente.isPresent())
			return new ResponseEntity<Cliente>(cliente.get(), HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/cliente", method = RequestMethod.POST)
	public Cliente saveCliente(@Valid @RequestBody Cliente cliente) {
		clienteUtil.verificarCpf(cliente.getCpf());
		if(clienteRepository.findById(cliente.getCpf()) != null)
				throw new ClienteException("Cliente já cadastrado!");
		
		return clienteRepository.save(cliente);
	}

	@RequestMapping(value = "/cliente/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Cliente> updateCliente(@PathVariable(value = "id") String cpf,
			@Valid @RequestBody Cliente newCliente) {
		Optional<Cliente> oldCliente = clienteRepository.findById(cpf);
		if (oldCliente.isPresent()) {
			Cliente cliente = oldCliente.get();
			cliente.setNome(newCliente.getNome());
			cliente.setDdd(newCliente.getDdd());
			cliente.setEmail(newCliente.getEmail());
			cliente.setNumCelular(newCliente.getNumCelular());

			clienteRepository.save(cliente);
			return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
		} else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/cliente/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteCliente(@PathVariable(value = "id") String cpf) {
		Optional<Cliente> cliente = clienteRepository.findById(cpf);
		if (cliente.isPresent()) {
			clienteRepository.delete(cliente.get());
			return new ResponseEntity<>(HttpStatus.OK);
		} else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

}
