package com.acc.i_pet_food.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "racao")
public class Racao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "rac_id_pk")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "rac_nome")
	private String nome;
	
	@Column(name = "rac_preco")
	private Double preco;
	
	@Column(name = "rac_desconto")
	private Double desconto;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "rac_est_id_pk_fk")
	private Estoque estoque;
	
	
	@JsonIgnore
	@OneToMany(mappedBy="racao", cascade=CascadeType.ALL, targetEntity = Item.class)
    private Set<Item> itens = new HashSet<Item>();
	
	@JsonIgnore
	@OneToMany(mappedBy="racao", targetEntity = Pet.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Pet> pets = new HashSet<>();
	
	public Racao() {}

	public Racao(Integer id, String nome, Double preco, Double desconto,
			Estoque estoque) {
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.desconto = desconto;
		this.estoque = estoque;
	}
	
	

	public Set<Item> getItens() {
		return itens;
	}

	public void setItens(Set<Item> itens) {
		this.itens = itens;
	}

	public Set<Pet> getPets() {
		return pets;
	}

	public void setPets(Set<Pet> pets) {
		this.pets = pets;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Double getDesconto() {
		return desconto;
	}

	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}

	public Estoque getEstoque() {
		return estoque;
	}

	public void setEstoque(Estoque estoque) {
		this.estoque = estoque;
	}

	

	@Override
	public String toString() {
		return "Racao [id=" + id + ", nome=" + nome + ", preco=" + preco + ", desconto=" + desconto + ", estoque="
				+ estoque + ", itens=" + itens + ", pets=" + pets + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Racao other = (Racao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
