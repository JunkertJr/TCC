package aula20170417.herança;

import java.math.BigDecimal;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class ParticipanteQuadroSocial {
	
	@Id
	private String id;
	
	private BigDecimal percentual;
	
	@ManyToOne
	private Pessoa socio;
	
	@ManyToOne
	private Juridica juridica;
	
	
	public ParticipanteQuadroSocial() {
		this.id = UUID.randomUUID().toString();
	}
	
	public Pessoa getSocio() {
		return socio;
	}

	public void setSocio(Pessoa socio) {
		this.socio = socio;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public BigDecimal getPercentual() {
		return percentual;
	}

	public void setPercentual(BigDecimal percentual) {
		this.percentual = percentual;
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
		ParticipanteQuadroSocial other = (ParticipanteQuadroSocial) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	

	
	
	
}
