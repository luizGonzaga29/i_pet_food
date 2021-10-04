package com.acc.i_pet_food.exeption;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class TratadorDeExcecoes extends ResponseEntityExceptionHandler{

	@ExceptionHandler(value = {Exception.class})
	public ResponseEntity<Object> tratarExcecoes(Exception e, WebRequest request){
		String erro = e.getLocalizedMessage();
		if(erro == null) erro = e.toString();
		MensagensErro mensagensErro = new MensagensErro(new Date(), erro);
		return new ResponseEntity<>(mensagensErro, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
