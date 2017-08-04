package br.unicesumar.aula20170320;



import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



//diz que essa classe é gerenciada pela spring e controlada pelo o service 
@Service
//cada metado termina com a transação
@Transactional
public class CorService {
	
	//ele faz todas as conexão do banco
	@Autowired
	private CorRepository repo;
	

	public List<Cor> recuperarTodas(){
		return repo.findAll();
		
	}
	
	public Cor salvar(Cor nova){
		return repo.save(nova);
	}
}
