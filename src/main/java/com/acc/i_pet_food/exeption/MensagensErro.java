package com.acc.i_pet_food.exeption;

import java.util.Date;

public class MensagensErro {

	private Date data;
	private String mensagem;
	
	public MensagensErro() {}

	public MensagensErro(Date data, String mensagem) {
		this.data = data;
		this.mensagem = mensagem;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	
}
