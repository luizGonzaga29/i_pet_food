package com.acc.i_pet_food.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ClienteException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ClienteException(String msg) {
		super(msg);
	}
}
