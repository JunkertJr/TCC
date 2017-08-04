package aula20160919.repositoryJdbc;

import java.util.Set;

public interface CorRepository {

	
    void incluir(Cor cor);
	
	Set<Cor> getTodas();

	boolean excluir(String codigoParaExclusao);
	
}
