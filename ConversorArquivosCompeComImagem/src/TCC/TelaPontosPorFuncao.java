package TCC;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class TelaPontosPorFuncao extends JDialog {
	private static final long serialVersionUID = 1L;
	
	private static final String EXPORTACAO_DE_RELATORIO = "@ExportacaoDeRelatorio";

public TelaPontosPorFuncao() {	
		
		JButton btnOpenExplorer = new JButton("...");
		JButton btnCalcular = new JButton("Calcular pontos por função");
		JLabel labelPath = new JLabel("Informar o diretório: ");
		final JTextField fieldPath = new JTextField();
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
						File[] filesEncontrados = LeitorArquivo.buscaArquivoDoDiretorio(new File(path));
						List<File> filesJava = new ArrayList<>();
						
						for (File file : filesEncontrados) {
							
							String nome = file.getName();
							String s = nome.substring(nome.lastIndexOf(".", nome.length()));
							
							if(s.equals(".java")){
								filesJava.add(file);
							}
						}
						System.out.println(filesJava.get(0).getName());
						for (File file : filesJava) {
							FileReader fileReader = new FileReader(file);
							BufferedReader bufferedReader = new BufferedReader(fileReader);
							
							while(bufferedReader.ready()){
								String linha = bufferedReader.readLine();
								
								verificaPontos(linha);
								System.out.println(linha);
							}
						}
						
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
		
		ActionListener acaoSair = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int Confirm = JOptionPane.showConfirmDialog(null, "Deseja encerrar?", "sim ou nao", JOptionPane.YES_NO_OPTION);
				if (Confirm == JOptionPane.YES_OPTION) {
					System.exit(0);
				} else if (Confirm == JOptionPane.NO_OPTION) {
					setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

				}
			}
		};
		btnSair.addActionListener(acaoSair);
	}

	private void verificaPontos(String linha) {
		if (linha.contains(EXPORTACAO_DE_RELATORIO)) {
			
		}
	}			

	private void configuracoesDaTela() {
		
		this.setTitle("Calculadora de pontos por função v1.1");
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setSize(450, 300);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		
	}


}
