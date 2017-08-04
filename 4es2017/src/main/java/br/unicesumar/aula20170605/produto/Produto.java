package br.unicesumar.aula20170605.produto;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Produto {
	@Id
	private String id;
	
	
	@Column(nullable=false, unique=true)
	private String nome;
	
	
	
	public Produto() {
		this.id = UUID.randomUUID().toString();
	}



	public String getId() {
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
		Produto other = (Produto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	

}
