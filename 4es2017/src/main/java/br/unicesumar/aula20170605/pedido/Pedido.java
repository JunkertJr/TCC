package br.unicesumar.aula20170605.pedido;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Pedido {
	@Id
	private String id;
	
	@Column(nullable=false)
	private Date emissao;
	
	@Column(nullable=false, unique=true)
	private Integer numero;
	
	public Pedido() {
		this.id = UUID.randomUUID().toString();
	}	
	
	public Pedido(Date emissao, Integer numero) {
		this();
		this.emissao = emissao;
		this.numero = numero;
	}


	public String getId() {
		return id;
	}

	public Date getEmissao() {
		return emissao;
	}

	public Integer getNumero() {
		return numero;
	}
	
	
	

}
