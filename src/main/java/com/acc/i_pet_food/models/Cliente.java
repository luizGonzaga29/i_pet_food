package com.acc.i_pet_food.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Cliente")
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "cli_CPF_pk")
	private String cpf;
	
	@Column(name = "cli_nome", nullable=false)
	private String nome;
	
	@Column(name = "cli_mesano_nascto", nullable=false)
	private Date dataNascimento;
	
	@Column(name = "cli_ddd", nullable=false)
	private Integer ddd;
	
	@Column(name = "cli_email", nullable=false, unique=true)
	private String email;
	
	@Column(name = "cli_celular_zap", nullable=false, unique=true)
	private Integer numCelular;

	public Cliente() {}

	public Cliente(String cpf, String nome, Date dataNascimento, Integer ddd, String email, Integer numCelular) {
		this.cpf = cpf;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.ddd = ddd;
		this.email = email;
		this.numCelular = numCelular;
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
