package aula20160913.repositoryJdbc;

import java.util.Set;

public interface CorRepository {

	
    void incluir(Cor cor);
	
	Set<Cor> getTodas();

	boolean excluir(String codigoParaExclusao);
	
}
