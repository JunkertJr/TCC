package aula20160919.repositoryJdbc;

public class Cor {
	private String codigo;
	private String nome;

	public Cor(String codigo, String nome) {
		validarCodigoNuloOuVazio(codigo);
		validarNomeNuloOuVazio(nome);
		this.codigo = codigo;
		this.nome = nome;		
	}

	private void validarNomeNuloOuVazio(String nome) {
		if (nome == null || nome.trim().length() == 0) {
			throw new RuntimeException("O nome da cor não pode ser nulo nem vazio!");
		}
	}

	private void validarCodigoNuloOuVazio(String codigo) {
		if (codigo == null || codigo.trim().length() == 0) {
			throw new RuntimeException("O código da cor não pode ser nulo nem vazio!");
		}
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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
