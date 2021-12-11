package com.acc.i_pet_food.models;

import java.io.Serializable;
import java.util.Date;
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

//dfgdgdgdgdgdgdgd
@Entity
@Table(name = "cliente")
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "cli_CPF_pk", nullable = false)
	private String cpf;
	
	@Column(name = "cli_nome")
	private String nome;
	
	@Column(name = "cli_bairro")
	private String bairro;
	
	@Column(name = "cli_mesano_nascto")
	private Date dataNascimento;
	
	@Column(name = "cli_ddd")
	private Integer ddd;
	
	@Column(name = "cli_email")
	private String email;
	
	@Column(name = "cli_celular_zap")
	private Integer numCelular;
	
	@JsonIgnore
	@OneToMany(mappedBy="cliente", targetEntity = Compra.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Compra> compras = new HashSet<>();
	
	@JsonIgnore
	@OneToMany(mappedBy="cliente", targetEntity = Pet.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Pet> pets = new HashSet<>(); 

	public Cliente() {}

	public Cliente(String cpf, String nome, Date dataNascimento, Integer ddd, String email, Integer numCelular) {
		this.cpf = cpf;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.ddd = ddd;
		this.email = email;
		this.numCelular = numCelular;
	}
	
	public Set<Compra> getCompras(){
		return compras;
	}
	
	public Set<Pet> getPets(){
		return pets;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Integer getDdd() {
		return ddd;
	}

	public void setDdd(Integer ddd) {
		this.ddd = ddd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getNumCelular() {
		return numCelular;
	}

	public void setNumCelular(Integer numCelular) {
		this.numCelular = numCelular;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public String toString() {
		return "Cliente [cpf=" + cpf + ", nome=" + nome + ", dataNascimento=" + dataNascimento + ", ddd=" + ddd
				+ ", email=" + email + ", numCelular=" + numCelular + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
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
		Cliente other = (Cliente) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		return true;
	}

	
}
