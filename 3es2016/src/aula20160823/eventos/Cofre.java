package aula20160823.eventos;

public class Cofre {
	private boolean aberto;
	private OuvidorDeEventosDoCofre ouvidor;
	
	public void abrir() {
		this.aberto = true;
		if (temOuvidor()) {
			ouvidor.cofreFoiAberto();
		}
	}

	public void fechar() {
		this.aberto = false;
		if (temOuvidor()) {
			ouvidor.cofreFoiFechado();
		}
	}

	public void setOuvidor(OuvidorDeEventosDoCofre o) {
		this.ouvidor = o;
	}
	
	private boolean temOuvidor() {
		return ouvidor != null;
	}
	
	public boolean isAberto() {
		return this.aberto;
	}
	public boolean isFechado() {
		return !isAberto();
	}
}
