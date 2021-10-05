package com.acc.i_pet_food.util;



import com.acc.i_pet_food.exeption.ClienteException;


public class ClienteUtil {

	
	public void verificarCpf(String cpf) {
		if(cpf.length() != 11  || !cpf.matches("^[0-9]*$")) 
			throw new ClienteException("Algo errado com o cpf, o mesmo deve conter apenas 11 números");
		
	}
	
	
}
