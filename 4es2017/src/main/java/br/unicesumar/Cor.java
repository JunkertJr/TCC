package br.unicesumar;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Cor {
	
	@Id
	private Long id;
	
	private String nome;
	
	
	public Cor() {
	}


	public Cor(Long id, String nome) {
		this.id = id;
		this.nome = nome;
	}


	public Long getId() {
		return id;
	}


	public String getNome() {
		return nome;
	}


	@Override
	public String toString() {
		return "Cor [id=" + id + ", nome=" + nome + "]";
	}
}
