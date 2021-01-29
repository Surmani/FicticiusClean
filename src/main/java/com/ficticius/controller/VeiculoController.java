package com.ficticius.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ficticius.model.Veiculo;
import com.ficticius.model.VeiculoVO;
import com.ficticius.repository.VeiculoRepository;
import com.ficticius.service.PrevisaoGastosService;

@RestController
@RequestMapping("api/veiculo")
public class VeiculoController {

	@Autowired
	private VeiculoRepository veiculoRepository;
	
	@Autowired 
	private PrevisaoGastosService previsaoGastosService;
	
	private SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");
	
	
	@GetMapping (path = "/listar")
	public List<Veiculo> listarVeiculos() {
		return veiculoRepository.findAll();
	}
	
	@GetMapping (path = "/inserirDadosTeste")
	public String inserirDadosTeste() throws ParseException {
		//Dados ficticios
		Veiculo v1 = new Veiculo("Enzo", "Ferrari", "Ferrari", dataFormatada.parse("01/01/2002"), 4.5, 7.4);//2002
		Veiculo v2 = new Veiculo("Ka", "Ford", "Ford Ka", dataFormatada.parse("01/01/2014"),  7.2, 10.5);//2014
		Veiculo v3 = new Veiculo("GM Onix", "Chevrolet", "Onix", dataFormatada.parse("01/01/2008"), 7.0, 11.0);//2008
		Veiculo v4 = new Veiculo("Crossfox", "Volkswagem", "Fox", dataFormatada.parse("01/01/2010"), 5.0, 13.0);//2010
		Veiculo v5 = new Veiculo("A3", "Audi", "Sedã Médio", dataFormatada.parse("01/01/2000"), 8.4, 9.2);//2000
		veiculoRepository.save(v1);
		veiculoRepository.save(v2);
		veiculoRepository.save(v3);
		veiculoRepository.save(v4);
		veiculoRepository.save(v5);
		
		return "sucesso";
	}
	
	@GetMapping (path = "/{id}")
	public ResponseEntity<Veiculo> buscarVeiculo(@PathVariable("id") Long id) {
		return veiculoRepository.findById(id).map(v -> ResponseEntity.ok().body(v))
				.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping(path = "/salvar")
	public Veiculo salvar(@RequestBody Veiculo veiculo) {
		return veiculoRepository.save(veiculo);
	}
	
	@PostMapping(path = "/salvarParametros")
	public Veiculo salvarParametros(@RequestParam(value = "nome") String nome, 
			@RequestParam(value = "marca") String marca, 
			@RequestParam(value = "modelo") String modelo,
			@RequestParam(value = "dataFabricacao") String dataFabricacao,
			@RequestParam(value = "consumoMedioCidade") Double consumoMedioCidade,
			@RequestParam(value = "consumoMedioRodovia") Double consumoMedioRodovia) throws ParseException{
		
		Veiculo veiculo = new Veiculo(nome, marca, modelo, dataFormatada.parse(dataFabricacao), consumoMedioCidade, consumoMedioRodovia);
		return veiculoRepository.save(veiculo);
	}
	
	@GetMapping(path ="/previsao")
	public List<VeiculoVO> previsaoDeGastos(@RequestParam(value = "precoGasolina") Double precoGasolina, 
			@RequestParam(value = "kmCidade") Double kmCidade, @RequestParam(value = "kmRodovia") Double kmRodovia){
		return previsaoGastosService.calcularPrevisaoGastos(precoGasolina, kmCidade, kmRodovia);
	}
	
}
