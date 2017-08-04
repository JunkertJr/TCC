package aula20160913.repositoryJdbc;

import java.util.Set;

public class CorService {
	//private CorRepository repo = new CorRepositoryTransient();
	//private CorRepository repo = new CorRepositoryPersistent();
	private CorRepository repo = CorRepositoryManager.getRepository();

	public void incluir(Cor cor) {
		//begin transaction
		repo.incluir(cor);
		//commit/rollback		
	}


	public Set<Cor> getTodas() {
		return repo.getTodas();
	}


	public boolean excluir(String codigoParaExclusao) {
		return repo.excluir(codigoParaExclusao);		
	}
	

}
