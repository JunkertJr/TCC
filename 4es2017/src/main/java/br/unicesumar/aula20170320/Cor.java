package br.unicesumar.aula20170320;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cor {
	//defini chave primaria
	@Id
	//gera sozinho a sequência e faz sozinho
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String nome;
	
	public Cor (){
		
	}

	public Cor( String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Cor [id=" + id + ", nome=" + nome + "]";
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
