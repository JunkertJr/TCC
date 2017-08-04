package tcc2017;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class TelaManterCor extends JDialog {
	
	public TelaManterCor() {		
		JButton btnOpenExplorer = new JButton("...");
		JLabel labelPath = new JLabel("Informar o diretório: ");
		JTextField fieldPath = new JTextField(15);
		
		configuracoesDaTela();
		
		//definindo o layout manager...
		GridBagLayout layout = new GridBagLayout();
		this.setLayout(layout);
		
		GridBagConstraints constraints = new GridBagConstraints();

		constraints.anchor = GridBagConstraints.WEST;
		constraints.fill = GridBagConstraints.HORIZONTAL;

		constraints.gridx = 0;
		constraints.gridy = 0;
		this.add(labelPath, constraints);
		
		constraints.gridx = 1;
		constraints.gridy = 0;
		this.add(fieldPath, constraints);
		
		constraints.gridx = 2;
		constraints.gridy = 0;			
		this.add(btnOpenExplorer, constraints);
		
		ActionListener acaoIncluir = new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String path;
				
				JFileChooser chooser = new JFileChooser(); 
			    chooser.setDialogTitle("Informe o arquivo de entrada:");
			    chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

			    if (chooser.showOpenDialog(chooser) == JFileChooser.APPROVE_OPTION) { 
			    	try {
						path = chooser.getSelectedFile().getCanonicalPath();
						fieldPath.setText(path);
					} catch (IOException e) {
						e.printStackTrace();
					}
			      }
			    else {
			    	JOptionPane.showMessageDialog(null, "Por favor, selecione um arquivo ou diretório.");
			    }	
				
			}			
		};
		
		btnOpenExplorer.addActionListener(acaoIncluir);
		
		ActionListener acaoListar = new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("== listagem de cores ==");
			}			
		};
		
	}

	private void configuracoesDaTela() {
		
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setSize(400, 300);
		this.setTitle("Calculadora de pontos por função v1.0");
		this.setLocationRelativeTo(null);
		
	}


}
