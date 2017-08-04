package aula20160808.ui.comBuilder;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class TelaManterCor extends JDialog {
//	private JButton btnIncluir = new JButton("Incluir");
//	private JLabel labelCodigo = new JLabel("Código");
//	private JLabel labelNome = new JLabel("Nome");
//	private JTextField fieldCodigo = new JTextField(5);
//	private JTextField fieldNome = new JTextField(15);
	
	public TelaManterCor() {
		JButton btnIncluir = new JButton("Incluir");
		JLabel labelCodigo = new JLabel("Código");
		JLabel labelNome = new JLabel("Nome");
		JTextField fieldCodigo = new JTextField(5);
		JTextField fieldNome = new JTextField(15);
		
		
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setSize(350, 250);
		this.setTitle("Manter Cor v0.23 beta");
		
		//definindo o layout manager...
		GridBagLayout layout = new GridBagLayout();
		this.setLayout(layout);
		
		GridBagConstraints constraints = new GridBagConstraints();

		constraints.anchor = GridBagConstraints.WEST;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.gridx = 0;
		constraints.gridy = 0;
		this.add(labelCodigo, constraints);
		
		constraints.gridx = 1;
		constraints.gridy = 0;
		this.add(fieldCodigo, constraints);
		
		constraints.gridx = 0;
		constraints.gridy = 1;
		this.add(labelNome, constraints);
		
		constraints.gridx = 1;
		constraints.gridy = 1;
		this.add(fieldNome, constraints);
		
		constraints.gridx = 0;
		constraints.gridy = 2;			
		this.add(btnIncluir, constraints);
		
		ActionListener açãoDoBotãoIncluir = new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Você digitou: [" + fieldCodigo.getText()+"] - " +fieldNome.getText() );				
			}			
		};
		
		btnIncluir.addActionListener(açãoDoBotãoIncluir);
	}


}
