package aula20160913.repositoryJdbc;



public abstract class CorRepositoryManager {

	public static CorRepository getRepository() {
		//String tipoRepoCor = System.getProperty("TipoRepositorioDaCor");
		String tipoRepoCor = Messages.getString("TipoRepositorioDaCor");
		
		if (tipoRepoCor.equals("transient")) {
			return new CorRepositoryTransient();
		} else if (tipoRepoCor.equals("persistent")) {
			return new CorRepositoryPersistent();
		} else {
			throw new RuntimeException("Deve ser selecionado um tipo de repo para a cor.");
		}
	}
}
