package aula20170417.herança;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;


@Entity
public class Juridica extends Pessoa {
	@Column(unique=true)
	private String cnpj;
	
	@OneToMany(mappedBy="juridica",cascade=CascadeType.ALL)
	private List<ParticipanteQuadroSocial> socios = new ArrayList<>();
	
	
	public ParticipanteQuadroSocial adicionarSocio(Pessoa socio, BigDecimal percentual) {
		ParticipanteQuadroSocial novoSocio = new ParticipanteQuadroSocial();
		novoSocio.setSocio(socio);
		novoSocio.setPercentual(new BigDecimal("20.00"));
		this.socios.add(novoSocio);
		return novoSocio;
	}
	

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	

}
