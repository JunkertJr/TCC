package aula20160830.ui;

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
	private CorService service = new CorService();
	
	public TelaManterCor() {		
		JButton btnIncluir = new JButton("Incluir");
		JButton btnExcluir = new JButton("Excluir");
		JButton btnListar = new JButton("Listar");
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
		
		constraints.gridx = 0;
		constraints.gridy = 3;			
		this.add(btnListar, constraints);
		
		constraints.gridx = 0;
		constraints.gridy = 4;			
		this.add(btnExcluir, constraints);

		ActionListener açãoDoBotãoIncluir = new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//JOptionPane.showMessageDialog(null, "Você digitou: [" + fieldCodigo.getText()+"] - " +fieldNome.getText() );
				try {
					service.incluir(new Cor(fieldCodigo.getText(), fieldNome.getText()));
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}			
		};
		
		btnIncluir.addActionListener(açãoDoBotãoIncluir);
		
		ActionListener açãoDoBotãoListar = new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("== listagem de cores ==");
				for (Cor cor : service.getTodas()) {
					System.out.println(cor.toString());
				}
			}			
		};
		
		btnListar.addActionListener(açãoDoBotãoListar);
		
		ActionListener açãoDoBotãoExcluir = new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int confirmacao = JOptionPane.showConfirmDialog(null, "Deseja excluir?","Confirmar",JOptionPane.YES_NO_OPTION);
				if (confirmacao == JOptionPane.YES_OPTION) {
					System.out.println("Tentando excluir...");
					
					if (service.excluir(fieldCodigo.getText())) {						
						JOptionPane.showMessageDialog(null, "Cor excluída com imenso sucesso!!! :D");
						
						fieldCodigo.setText("");
						fieldNome.setText("");
					} else {
						JOptionPane.showMessageDialog(null, "Cor não localizada.");						
					}
					
				}
			}			
		};
		
		btnExcluir.addActionListener(açãoDoBotãoExcluir);

	}


}
