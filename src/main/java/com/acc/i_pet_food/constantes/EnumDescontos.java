package com.acc.i_pet_food.constantes;

public enum EnumDescontos {

	ACIMA300(0.85),
	ENTE200E300(0.9),
	ENTRE100E200(0.95);

	private double desconto;

	EnumDescontos(double desconto) {
		this.desconto = desconto;
	}

	public double getDesconto() {
		return desconto;
	}
}
