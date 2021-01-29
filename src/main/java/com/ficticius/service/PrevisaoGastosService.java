package com.ficticius.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Comparator;

import org.apache.commons.math3.util.Precision;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ficticius.model.Veiculo;
import com.ficticius.model.VeiculoVO;
import com.ficticius.repository.VeiculoRepository;

@Service
public class PrevisaoGastosService {

	@Autowired
	private VeiculoRepository veiculoRepository;
	
	public List<VeiculoVO> calcularPrevisaoGastos(Double precoGasolina, Double kmCidade, Double kmRodovia) {
		List<Veiculo> veiculos = veiculoRepository.findAll();
		
		return veiculos.stream().map(v -> {
			Double combustivelGasto = calcularCombustivelGasto(v, kmRodovia, kmCidade);
			Double valorGasto = calcularValorGasto(combustivelGasto, precoGasolina);
			return new VeiculoVO(v,combustivelGasto, valorGasto);
		}).sorted(Comparator.comparing(VeiculoVO::getValorGasto)).collect(Collectors.toList());
	}

	private Double calcularValorGasto(Double combustivelGasto, Double precoGasolina) {
		return Precision.round(combustivelGasto * precoGasolina, 2);
	}

	private Double calcularCombustivelGasto(Veiculo veiculo, Double kmCidade, Double kmRodovia) {
		Double combustivelGastoCidade = kmCidade/veiculo.getConsumoMedioCidade();
		Double combustivelGastoRodovia = kmRodovia/veiculo.getConsumoMedioRodovia();
		return Precision.round((combustivelGastoCidade + combustivelGastoRodovia), 3); //Ida e volta
	}
	
}
