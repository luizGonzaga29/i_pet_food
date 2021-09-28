package com.acc.i_pet_food.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pet")
public class Pet implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "pet_id_pk")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "pet_especie")
	private String especie;
	
	@Column(name = "pet_nome")
	private String nome;
	
	@Column(name = "pet_apelido")
	private String apelido;
	
	@Column(name = "pet_dt_nascto")
	private Date dataNascimento;
	
	@Column(name = "pet_raca")
	private String raca;
	
	@Column(name = "pet_genero")
	private String genero;
	
	@Column(name = "pet_peso")
	private Float peso;
	
	@ManyToOne
	@JoinColumn(name = "cmp_cli_CPF_pk_fk")
	private Cliente cliente;

	public Pet() {}

	public Pet(Integer id, String especie, String nome, String apelido, Date dataNascimento, String raca, String genero,
			Float peso, Cliente cliente) {
		this.id = id;
		this.especie = especie;
		this.nome = nome;
		this.apelido = apelido;
		this.dataNascimento = dataNascimento;
		this.raca = raca;
		this.genero = genero;
		this.peso = peso;
		this.cliente = cliente;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Float getPeso() {
		return peso;
	}

	public void setPeso(Float peso) {
		this.peso = peso;
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
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
		Pet other = (Pet) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
}
