package br.unicesumar.aula20170320;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//ele vai subir o servidor 
@RestController
//tudo que subir o sprig sabe que tem que rotear para cor
@RequestMapping("/cor")
public class CorController {
	
	//ele se vira para acesssar o servidor
	@Autowired
	private CorService service;
	
	@RequestMapping(method=RequestMethod.GET, value="")
	public List<Cor> getALL(){
		return service.recuperarTodas();
	}
	
	@RequestMapping(method=RequestMethod.POST, value="")
	
	public Cor put (@RequestBody Cor nova){
		return service.salvar(nova);
	}
	
	

}
