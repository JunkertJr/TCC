package aula20160822.eventos;

public class Cofre {
	private boolean aberto;
	private OuvidorDeEventosDoCofre ouvidor;
	
	public void abrir() {
		this.aberto = true;
		if (ouvidor != null) {
			ouvidor.cofreFoiAberto();
		}
	}
	
	public void fechar() {
		this.aberto = false;
		if (ouvidor != null) {
			ouvidor.cofreFoiFechado();
		}
	}

	public void setOuvidor(OuvidorDeEventosDoCofre o) {
		this.ouvidor = o;
	}
}
