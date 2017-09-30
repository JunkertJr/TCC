package TCC;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
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
	
	private static final String CE_ALTA = "@CE_ALTA";
	private static final String CE_MEDIA = "@CE_MEDIA";
	private static final String CE_BAIXA = "@CE_BAIXA";
	private static final String OE_ALTA = "@OE_ALTA";
	private static final String OE_MEDIA = "@OE_MEDIA";
	private static final String OE_BAIXA = "@OE_BAIXA";
	private static final String IE_ALTA = "@IE_ALTA";
	private static final String IE_MEDIA = "@IE_MEDIA";
	private static final String IE_BAIXA = "@IE_BAIXA";
	private static final String AIE_ALTA = "@AIE_ALTA";
	private static final String AIE_MEDIA = "@AIE_MEDIA";
	private static final String AIE_BAIXA = "@AIE_BAIXA";
	private static final String ALI_ALTA = "@ALI_ALTA";
	private static final String ALI_MEDIA = "@ALI_MEDIA";
	private static final String ALI_BAIXA = "@ALI_BAIXA";

	private BigInteger pontosTotais;

	public TelaPontosPorFuncao() {

		JButton btnOpenExplorer = new JButton("...");
		JButton btnCalcular = new JButton("Calcular pontos por função");
		JLabel labelPath = new JLabel("Informar o diretório: ");
		final JTextField fieldPath = new JTextField();
		JButton btnSair = new JButton("Sair");

		final JLabel labelResultadoDiretorio = new JLabel("A quantidade de pontos por função nesse diretório é: ");

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

		ActionListener acaoIncluir = new ActionListener() {
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
				} else {
					JOptionPane.showMessageDialog(null, "Por favor, selecione um arquivo ou diretório.");
				}
			}
		};
		btnOpenExplorer.addActionListener(acaoIncluir);

		ActionListener acaoCalcular = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String path = fieldPath.getText();
				
				if (path.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Por favor, informe um diretório ou arquivo.");
				} else {
					
					try {
						calculaPontos(path);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
				
			}
		};
		btnCalcular.addActionListener(acaoCalcular);

		ActionListener acaoSair = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int Confirm = JOptionPane.showConfirmDialog(null, "Deseja encerrar?", "Confirma saída",
						JOptionPane.YES_NO_OPTION);
				if (Confirm == JOptionPane.YES_OPTION) {
					System.exit(0);
				} else if (Confirm == JOptionPane.NO_OPTION) {
					setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

				}
			}
		};
		btnSair.addActionListener(acaoSair);
	}

	private void validaFilesEncontrados(List<File> filesJava) {
		if (filesJava.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Não foi encontrado arquivo Java nesse diretório.");
		}
	}
	
	private void calculaPontos(String path) throws FileNotFoundException, IOException {
		File[] filesEncontrados = LeitorArquivo.buscaArquivoDoDiretorio(new File(path));
		List<File> filesJava = new ArrayList<>();

		for (File file : filesEncontrados) {

			String nome = file.getName();
			String s = nome.substring(nome.lastIndexOf(".", nome.length()));

			if (s.equals(".java")) {
				filesJava.add(file);
			}
		}
		
		validaFilesEncontrados(filesJava);
		
		for (File file : filesJava) {
			FileReader fileReader = new FileReader(file);
			@SuppressWarnings("resource")
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			while (bufferedReader.ready()) {
				String linha = bufferedReader.readLine();

				verificaPontos(linha);
				System.out.println(linha);
			}
		}
	}

	private void verificaPontos(String linha) {

		if (linha.contains(ALI_BAIXA)) {
			pontosTotais.add(new BigInteger("7"));

		} else if (linha.contains(ALI_MEDIA)) {
			pontosTotais.add(new BigInteger("10"));
			
		} else if (linha.contains(ALI_ALTA)) {
			pontosTotais.add(new BigInteger("15"));
			
		} else if (linha.contains(AIE_BAIXA)) {
			pontosTotais.add(new BigInteger("5"));
			
		} else if (linha.contains(AIE_MEDIA)) {
			pontosTotais.add(new BigInteger("7"));
			
		} else if (linha.contains(AIE_ALTA)) {
			pontosTotais.add(new BigInteger("10"));
			
		} else if (linha.contains(IE_BAIXA)) {
			pontosTotais.add(new BigInteger("3"));
			
		} else if (linha.contains(IE_MEDIA)) {
			pontosTotais.add(new BigInteger("4"));
			
		} else if (linha.contains(IE_ALTA)) {
			pontosTotais.add(new BigInteger("6"));
			
		} else if (linha.contains(OE_BAIXA)) {
			pontosTotais.add(new BigInteger("4"));
			
		} else if (linha.contains(OE_MEDIA)) {
			pontosTotais.add(new BigInteger("5"));
			
		} else if (linha.contains(OE_ALTA)) {
			pontosTotais.add(new BigInteger("7"));
			
		} else if (linha.contains(CE_BAIXA)) {
			pontosTotais.add(new BigInteger("3"));
			
		} else if (linha.contains(CE_MEDIA)) {
			pontosTotais.add(new BigInteger("4"));
			
		} else if (linha.contains(CE_ALTA)) {
			pontosTotais.add(new BigInteger("6"));
			
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
