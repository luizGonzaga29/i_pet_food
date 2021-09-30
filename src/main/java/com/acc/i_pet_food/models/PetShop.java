package com.acc.i_pet_food.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "petShop")
public class PetShop implements Serializable {

	private static final long serialVersionUID = 1L;
	

	@Id
	@Column(name = "pets_CNPJ_pk")
	private String cnpj;
	
	@Column(name = "pets_razao_social")
	private String razaoSocial;
	
	@Column(name = "pets_nome_fantasia")
	private String nomeFantasia;
	
	@Column(name = "pets_email")
	private String email;
	
	@Column(name = "pets_nm_resp")
	private String nomeResponsavel;
	
	
	@JsonIgnore
	@OneToMany(mappedBy="petShop", targetEntity = Estoque.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Estoque> estoques = new HashSet<>();
	
	public PetShop() {}

	public PetShop(String cnpj, String razaoSocial, String nomeFantasia, String email, String nomeResponsavel) {
		
		this.cnpj = cnpj;
		this.razaoSocial = razaoSocial;
		this.nomeFantasia = nomeFantasia;
		this.email = email;
		this.nomeResponsavel = nomeResponsavel;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNomeResponsavel() {
		return nomeResponsavel;
	}

	public void setNomeResponsavel(String nomeResponsavel) {
		this.nomeResponsavel = nomeResponsavel;
	}

	public Set<Estoque> getEstoque(){
		return estoques;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "PetShop [cnpj=" + cnpj + ", razaoSocial=" + razaoSocial + ", nomeFantasia=" + nomeFantasia + ", email="
				+ email + ", nomeResponsavel=" + nomeResponsavel + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cnpj == null) ? 0 : cnpj.hashCode());
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
		PetShop other = (PetShop) obj;
		if (cnpj == null) {
			if (other.cnpj != null)
				return false;
		} else if (!cnpj.equals(other.cnpj))
			return false;
		return true;
	}
	
	
	
	
}
