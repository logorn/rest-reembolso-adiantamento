package rest.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import rest.model.TipoDespesa;
import rest.service.TipoDespesaService;

@RestController
@Component
public class DespesaController {
	
	@Autowired
	private TipoDespesaService tipoDespesaService;
	
	@RequestMapping(path="/despesa/tipo-despesa", method=RequestMethod.GET)
	public List<TipoDespesa> tiposDespesa() {
		return tipoDespesaService.findAll();
	}	
	
	@PostConstruct
    public void popularTipoDespesas() {
		tipoDespesaService.save(new TipoDespesa("Transporte"));
		tipoDespesaService.save(new TipoDespesa("Reunião"));
		tipoDespesaService.save(new TipoDespesa("Gasolina"));
		tipoDespesaService.save(new TipoDespesa("Manutenção"));
		tipoDespesaService.save(new TipoDespesa("Seguro"));
		tipoDespesaService.save(new TipoDespesa("Refeição"));
    }
}