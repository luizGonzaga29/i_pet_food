package com.acc.i_pet_food.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "racao")
public class Racao implements Serializable {

	private static final long serialVersionUID = 1L;
	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

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
	
	@Column(name = "rac_dt_cad_ini")
	private Date dataInicio;
	
	@Column(name = "rac_dt_cad_fim")
	private Date dataFim;
	
	@ManyToOne
	@JoinColumn(name = "rac_est_id_pk_fk")
	private Estoque estoque;
	
	@ManyToMany
	@JoinTable(
	  name = "compra_racao", 
	  joinColumns = @JoinColumn(name = "rac_id_pk"), 
	  inverseJoinColumns = @JoinColumn(name = "cmp_id_pk"))
	List<Compra> compras = new ArrayList<>();
	
	public Racao() {}

	public Racao(Integer id, String nome, Double preco, Double desconto, Date dataInicio, Date dataFim,
			Estoque estoque) {
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.desconto = desconto;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.estoque = estoque;
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

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public Estoque getEstoque() {
		return estoque;
	}

	public void setEstoque(Estoque estoque) {
		this.estoque = estoque;
	}

	@Override
	public String toString() {
		return "Racao [id=" + id + ", nome=" + nome + ", preco=" + preco + ", desconto=" + desconto + ", dataInicio="
				+ dataInicio + ", dataFim=" + dataFim + ", estoque=" + estoque + "]";
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
