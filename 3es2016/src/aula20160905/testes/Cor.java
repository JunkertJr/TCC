package aula20160905.testes;

public class Cor {
	private String codigo;
	private String nome;

	public Cor(String codigo, String nome) {
		// validarCodigo(codigo);
		// this.codigo = codigo;
		this.setCodigo(codigo);
		this.setNome(nome);
	}
	
	private String tornarPrimeiraLetraMaiuscula(String s) {
		return s.substring(0,1).toUpperCase() + s.substring(1, s.length());
	}

	private void validarCodigoSeNumericoImpar(String codigo) {
		int codigoAsInt = Integer.parseInt(codigo);
		if (codigoAsInt % 2 != 0) {
			throw new RuntimeException(
					"Quando numérico, o código da cor deve ser par!");
		}
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		validarCodigoSeNumericoImpar(codigo);
		this.codigo = tornarPrimeiraLetraMaiuscula(codigo);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = tornarPrimeiraLetraMaiuscula(nome);
	}

	@Override
	public String toString() {
		return "Cor [codigo=" + codigo + ", nome=" + nome + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cor other = (Cor) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}
