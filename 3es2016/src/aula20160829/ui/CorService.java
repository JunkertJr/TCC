package aula20160829.ui;

import java.util.Set;

public class CorService {
	private CorRepository repo = new CorRepository();

	
	public void incluir(Cor cor) {
		//begin transaction
		repo.incluir(cor);
		//commit/rollback		
	}


	public Set<Cor> getTodas() {
		return repo.getTodas();
	}
	

}
