package com.acc.i_pet_food.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "itens")
public class Item implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "it_id_pk")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	
	@ManyToOne
	@JoinColumn(name = "it_cmp_id_pk_fk")
	private Compra compra;
	
	@ManyToOne
	@JoinColumn(name = "it_rac_id_pk_fk")
	private Racao racao;
	
	@Column(name = "it_qtd")
	private Double quantidade;
	
	@Column(name = "it_preco")
	private Double preco;
	
	@Column(name = "it_desconto")
	private Double desconto;

	public Compra getCompra() {
		return compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
	}

	public Racao getRacao() {
		return racao;
	}

	public void setRacao(Racao racao) {
		this.racao = racao;
	}

	public Double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
	}
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((compra == null) ? 0 : compra.hashCode());
		result = prime * result + ((racao == null) ? 0 : racao.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (compra == null) {
			if (other.compra != null)
				return false;
		} else if (!compra.equals(other.compra))
			return false;
		if (racao == null) {
			if (other.racao != null)
				return false;
		} else if (!racao.equals(other.racao))
			return false;
		return true;
	}

	
	
	
	
	
}

