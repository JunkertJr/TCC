package aula20160809.anonymousClass;

public class NotificadorDeUsoQueAvisaNoConsole implements NotificadorDeUso {

	@Override
	public void notificar(double valor) {
		System.out.println("Cart�o usado!!!! Valor=" + valor);
	}

}
