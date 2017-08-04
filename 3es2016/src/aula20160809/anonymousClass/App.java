package aula20160809.anonymousClass;

public class App {
	
	public static void main(String[] args) {
//		CartaoDeCredito visa2433 = new CartaoDeCredito();
		
//		NotificadorDeUso notificador = new NotificadorDeUsoQueAvisaNoConsole();		
		
		NotificadorDeUso notificador = new NotificadorDeUso() {
			@Override
			public void notificar(double valor) {
				System.out.println("Cartão usado!!!! Valor=" + valor);
			}			
		};

		//Exemplo de lambda expression suportada em Java a partir da versão 8, só vale para
		//interfaces com um único método
//		NotificadorDeUso notificador = (valor) -> System.out.println("Olha, comprou: " + valor); 
		
		CartaoDeCredito visa2433 = new CartaoDeCredito(notificador);
		visa2433.debitar(500.21);
		visa2433.debitar(15.10);
		visa2433.debitar(15.10);
		visa2433.debitar(15.10);
		visa2433.debitar(15.10);
		visa2433.debitar(15.10);
		visa2433.debitar(15.10);
		visa2433.debitar(15.10);
		visa2433.debitar(15.10);
		System.out.println(visa2433.getTotalDeDebitos());
	}

}
