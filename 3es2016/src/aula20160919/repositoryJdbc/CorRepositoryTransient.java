package aula20160919.repositoryJdbc;

import java.util.HashSet;
import java.util.Set;

public class CorRepositoryTransient implements CorRepository {
	private Set<Cor> dados = new HashSet<>();

	public void incluir(Cor cor) {
		if (this.dados.contains(cor)) {
			throw new RuntimeException("N�o � poss�vel cadastrar cores duplicadas! " + cor.toString());
		}
		this.dados.add(cor);
	}
	
	public Set<Cor> getTodas() {
		return this.dados;
	}

	public boolean excluir(String codigoParaExclusao) {
		for (Cor cor : dados) {
			if (cor.getCodigo().equalsIgnoreCase(codigoParaExclusao)) {
				dados.remove(cor);
				return true;
			}
		}
		return false;
	}
	

}
