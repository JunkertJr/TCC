package aula20160919.classeAnonima;

public class EnviadorDeMensagemViaSMS implements EnviadorDeMensagem {

	@Override
	public void enviar(String mensagem) {
		System.out.println("SMS: " + mensagem);
	}

}
