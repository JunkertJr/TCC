package aula20160823.eventos;

import javax.swing.JOptionPane;

public class App {
	
	public static void main(String[] args) {
		//criando um cofrinho... :P
		Cofre cofrinho = new Cofre();
		
		//criando um novo ouvidor mediante uso de classes anônimas suportadas pela linguagem Java:
		OuvidorDeEventosDoCofre ouvidor = new OuvidorQueNotificaNaTela();
		
		//vinculando o ouvidor ao cofrinho.... :D
		cofrinho.setOuvidor(ouvidor);

		for (int i = 0; i < 10; i++) {
			cofrinho.abrir();			
		}
		cofrinho.fechar();
		System.out.println("Fim.");
	}

}
