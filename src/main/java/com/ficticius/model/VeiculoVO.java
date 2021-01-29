package com.ficticius.model;

import java.text.SimpleDateFormat;

public class VeiculoVO {

	private String nome;
	private String marca;
	private String modelo;
	private String ano;
	private Double combustivelGasto;
	private Double valorGasto;

	private SimpleDateFormat formatYear = new SimpleDateFormat("yyyy");
	
	public VeiculoVO(Veiculo veiculo, Double combustivelGasto, Double valorGasto) {
		this.nome = veiculo.getNome();
		this.marca = veiculo.getMarca();
		this.modelo = veiculo.getModelo();
		this.ano = formatYear.format(veiculo.getDataFabricacao());
		this.combustivelGasto = combustivelGasto;
		this.valorGasto = valorGasto;
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
	public String getAno() {
		return ano;
	}
	public void setAno(String ano) {
		this.ano = ano;
	}
	public Double getCombustivelGasto() {
		return combustivelGasto;
	}
	public void setCombustivelGasto(Double combustivelGasto) {
		this.combustivelGasto = combustivelGasto;
	}
	public Double getValorGasto() {
		return valorGasto;
	}
	public void setValorGasto(Double valorGasto) {
		this.valorGasto = valorGasto;
	}
	
}
