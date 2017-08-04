package aula20160823.eventos;

import javax.swing.JOptionPane;

public class OuvidorQueNotificaNaTela implements OuvidorDeEventosDoCofre {

	@Override
	public void cofreFoiFechado() {
		System.out.println("Beleza, ele tem que ficar fechado mesmo!");
	}
	
	@Override
	public void cofreFoiAberto() {
		JOptionPane.showMessageDialog(null, "Oxe!!! Quem abriu o cofre????");
	}

}
