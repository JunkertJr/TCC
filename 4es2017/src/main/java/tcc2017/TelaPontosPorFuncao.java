package tcc2017;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TelaPontosPorFuncao extends JDialog {
	
	public TelaPontosPorFuncao() {	
		
		JButton btnOpenExplorer = new JButton("...");
		JButton btnCalcular = new JButton("Calcular pontos por função");
		JLabel labelPath = new JLabel("Informar o diretório: ");
		JTextField fieldPath = new JTextField();
		JButton btnSair = new JButton("Sair");
		
		JLabel labelResultadoDiretorio = new JLabel("A quantidade de pontos por função nesse diretório é: ");
		JLabel labelResultadoArquivo = new JLabel("A quantidade de pontos por função nesse(s) arquivo(s) é: ");
		
		configuracoesDaTela();
		
		labelPath.setBounds(18, 10, 118, 30);
		this.add(labelPath);
		
		fieldPath.setBounds(135, 15, 250, 20);
		this.add(fieldPath);
		
		btnOpenExplorer.setBounds(390, 14, 20, 20);
		btnOpenExplorer.setMnemonic(KeyEvent.VK_E);
		this.add(btnOpenExplorer);
		
		btnCalcular.setBounds(135, 40, 190, 20);
		this.add(btnCalcular);
		
		
		btnSair.setBounds(355, 220, 57, 25);
		btnSair.setMnemonic(KeyEvent.VK_S);
		this.add(btnSair);
		
		AtribuindoFuncoesAosButtons(btnOpenExplorer, btnCalcular, fieldPath, btnSair);
		
	}

	private void AtribuindoFuncoesAosButtons(JButton btnOpenExplorer, JButton btnCalcular, JTextField fieldPath, JButton btnSair) {
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
			    	if (chooser.getSelectedFile().isDirectory()) {
						System.out.println("Diretorio");
					} else {
						System.out.println("file");
					}
			      }	
			    
			    else {
			    	JOptionPane.showMessageDialog(null, "Por favor, selecione um arquivo ou diretório.");
			    }	
				
			}			
		};
		
		btnOpenExplorer.addActionListener(acaoIncluir);
		
		ActionListener acaoCalcular = new ActionListener(){
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
		
		btnCalcular.addActionListener(acaoCalcular);
		
		ActionListener acaoSair = new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}			
		};
		
		btnSair.addActionListener(acaoSair);
	}

	private void configuracoesDaTela() {
		
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setSize(450, 300);
		this.setTitle("Calculadora de pontos por função v1.0");
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		
	}


}
