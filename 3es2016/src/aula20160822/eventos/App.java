package aula20160822.eventos;

import javax.swing.JOptionPane;

public class App {
	
	public static void main(String[] args) {
		//criando um cofrinho... :P
		Cofre cofrinho = new Cofre();
		
		//criando um novo ouvidor mediante uso de classes anônimas suportadas pela linguagem Java:
		OuvidorDeEventosDoCofre ouvidor = new OuvidorDeEventosDoCofre() {
			@Override
			public void cofreFoiFechado() {
				System.out.println("Beleza, ele tem que ficar fechado mesmo!");
			}
			
			@Override
			public void cofreFoiAberto() {
				JOptionPane.showMessageDialog(null, "Oxe!!! Quem abriu o cofre????");
			}
		};
		
		//vinculando o ouvidor ao cofrinho.... :D
		cofrinho.setOuvidor(ouvidor);

		for (int i = 0; i < 10; i++) {
			cofrinho.abrir();			
		}
		cofrinho.fechar();
		System.out.println("Fim.");
	}

}
