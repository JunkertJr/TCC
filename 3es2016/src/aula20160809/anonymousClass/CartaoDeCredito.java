package aula20160809.anonymousClass;

public class CartaoDeCredito {
	private double totalDeDebitos = 0.00;
	private NotificadorDeUso notificador;
	
	public CartaoDeCredito() {
		
	}
	
	public CartaoDeCredito(NotificadorDeUso notificador) {
		this.notificador = notificador;
	}



	public void debitar(double valor) {
		totalDeDebitos += valor;
		if (this.notificador != null) {
			this.notificador.notificar(valor);
		}
	}
	
	
	public double getTotalDeDebitos() {
		return totalDeDebitos;
	}
	
	

}
