package rest.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import rest.model.Adiantamento;
import rest.model.CentroCusto;
import rest.service.AdiantamentoService;
import rest.service.CentroCustoService;

@RestController
@Component
public class AdiantamentoController {
	
	@Autowired
	private AdiantamentoService adiantamentoService;
	
	@Autowired
	private CentroCustoService centroCustoService;
	
	@RequestMapping(path="/adiantamento", method=RequestMethod.GET)
	public List<Adiantamento> adiantamentos() {
		return adiantamentoService.findAll();
	}	
	
	@RequestMapping(path="/adiantamento/{id}", method=RequestMethod.GET)
	public Adiantamento adiantamento(@PathVariable(value="id") long id) {
		return adiantamentoService.findById(id);
	}
	
	@RequestMapping(path="/adiantamento", method=RequestMethod.POST)
	public void salvarAdiantamento(@RequestBody Adiantamento adiantamento, HttpServletResponse response) throws Exception {
		
		try{
			long idCentroCusto = adiantamento.getCentroCusto().getId();			
			adiantamento.setCentroCusto(centroCustoService.findById(idCentroCusto));			
			adiantamentoService.save(adiantamento);
		}catch(Exception e){
			response.sendError(response.SC_NOT_ACCEPTABLE, "Please verify request body.");
		}		
	}
	
	@PostConstruct
    public void popularAdiantamentos() {
		centroCustoService.save(new CentroCusto("100.100.100/0001", "Departamento Pessoal"));
		adiantamentoService.save(new Adiantamento(1.0, false, centroCustoService.findById(1)));
		adiantamentoService.save(new Adiantamento(1.0, false, centroCustoService.findById(1)));
		adiantamentoService.save(new Adiantamento(0.1, false, centroCustoService.findById(1)));
		adiantamentoService.save(new Adiantamento(0.01, false, centroCustoService.findById(1)));
    }
}