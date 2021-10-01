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
@Table(name = "estoque")
public class Estoque implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "est_id_pk")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "est_nm_fabricante")
	private String nomeFabricante;
	
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "est_pets_CNPJ_pk_fk")
	private PetShop petShop;
	
	
	@OneToMany(mappedBy="estoque", targetEntity = Racao.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Racao> racoes = new HashSet<>();
	
	public Estoque() {}

	public Estoque(Integer id, String nomeFabricante, PetShop petShop) {
		this.id = id;
		this.nomeFabricante = nomeFabricante;
		this.petShop = petShop;
	}
	
	public Set<Racao> getRacoes(){
		return racoes;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeFabricante() {
		return nomeFabricante;
	}

	public void setNomeFabricante(String nomeFabricante) {
		this.nomeFabricante = nomeFabricante;
	}

	public PetShop getPetShop() {
		return petShop;
	}

	public void setPetShop(PetShop petShop) {
		this.petShop = petShop;
	}

	@Override
	public String toString() {
		return "Estoque [id=" + id + ", nomeFabricante=" + nomeFabricante + ", petShop=" + petShop + "]";
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
		Estoque other = (Estoque) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
