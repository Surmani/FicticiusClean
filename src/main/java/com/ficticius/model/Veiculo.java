package com.ficticius.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "veiculo")
public class Veiculo implements Serializable{

	private static final long serialVersionUID = -4722816371895995816L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nome;
	private String marca;
	private String modelo;
	@Column(name = "data_fabricacao")
	private Date dataFabricacao;
	@Column(name = "consumo_medio_cidade")
	private Double consumoMedioCidade;
	@Column(name = "consumo_medio_rodovia")
	private Double consumoMedioRodovia;
	
	public Veiculo() {
		super();
	}

	public Veiculo(String nome, String marca, String modelo, Date dataFabricacao, Double consumoMedioCidade,
			Double consumoMedioRodovia) {
		this.nome = nome;
		this.marca = marca;
		this.modelo = modelo;
		this.dataFabricacao = dataFabricacao;
		this.consumoMedioCidade = consumoMedioCidade;
		this.consumoMedioRodovia = consumoMedioRodovia;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public Date getDataFabricacao() {
		return dataFabricacao;
	}
	public void setDataFabricacao(Date dataFabricacao) {
		this.dataFabricacao = dataFabricacao;
	}
	public Double getConsumoMedioCidade() {
		return consumoMedioCidade;
	}
	public void setConsumoMedioCidade(Double consumoMedioCidade) {
		this.consumoMedioCidade = consumoMedioCidade;
	}
	public Double getConsumoMedioRodovia() {
		return consumoMedioRodovia;
	}
	public void setConsumoMedioRodovia(Double consumoMedioRodovia) {
		this.consumoMedioRodovia = consumoMedioRodovia;
	}

}
