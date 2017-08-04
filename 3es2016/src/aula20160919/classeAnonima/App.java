package aula20160919.classeAnonima;

public class App {
	
	public static void main(String[] args) {
		EnviadorDeMensagem enviador = new EnviadorDeMensagemViaSMS();
		
		
		EnviadorDeMensagem enviadorAnonimo = new EnviadorDeMensagem() {			
			@Override
			public void enviar(String mensagem) {
				System.out.println("Console agora, via classe anônima: " + mensagem);
			}
		};
		

		
		
		enviador.enviar("Oi Fulano!");
		enviadorAnonimo.enviar("Oi Fulano!");
		
	}

}
