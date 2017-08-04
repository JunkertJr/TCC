package aula20170417.herança;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity 
public class Fisica extends Pessoa {
	@Column(unique=true)
	private String cpf;

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

}
