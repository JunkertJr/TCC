package TCC;

import java.awt.Font;
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
import javax.swing.text.JTextComponent;

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

	private BigInteger pontosTotais = BigInteger.ZERO;

	public TelaPontosPorFuncao() {

		JLabel teste = new JLabel(); 
		JLabel labelPath = new JLabel("Diretório: ");
		final JTextField fieldPath = new JTextField();
		JButton btnOpenExplorer = new JButton("...");
		
		JButton btnCalcular = new JButton("Calcular pontos por função");
		JButton btnSair = new JButton("Sair");

		final JLabel labelResultado = new JLabel("Pontos por função: ");

		configuracoesDaTela();
		
		Font font = new Font("SansSerif", Font.BOLD, 15); 
		teste.setBounds(18, 20, 400, 60);
		teste.setText("<html><body><div style='text-align: center;'>Para usar a aplicação, informe algum diretório que contenha arquivos da extensão JAVA.</div></body></html>");
		teste.setFont(font);
		this.add(teste);
		
//		labelResultado.setBounds(18, 100, 118, 30);
//		labelResultado.setFont(fontPath);
//		this.add(labelResultado);
		
		Font fontPath = new Font("SansSerif", Font.BOLD, 14);
		labelPath.setBounds(18, 100, 118, 30);
		labelPath.setFont(fontPath);
		this.add(labelPath);
		
		fieldPath.setBounds(93, 106, 290, 20);
		this.add(fieldPath);

		btnOpenExplorer.setBounds(390, 105, 20, 20);
		btnOpenExplorer.setMnemonic(KeyEvent.VK_E);
		this.add(btnOpenExplorer);

		btnCalcular.setBounds(18, 185, 195, 30);
		btnCalcular.setMnemonic(KeyEvent.VK_C);
		this.add(btnCalcular);

		btnSair.setBounds(350, 185, 62, 30);
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

	private boolean validaFilesEncontrados(List<File> filesJava) {
		if (filesJava.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Não foi encontrado arquivo Java nesse diretório.");
			return false;
		}
		return true;
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
		
		if (validaFilesEncontrados(filesJava)){
			
			for (File file : filesJava) {
				FileReader fileReader = new FileReader(file);
				@SuppressWarnings("resource")
				BufferedReader bufferedReader = new BufferedReader(fileReader);
				
				while (bufferedReader.ready()) {
					String linha = bufferedReader.readLine();
					
					verificaPontos(linha);
					System.out.println(linha);
				}
				
				mostraResultado(this);
			}
		}
		
	}

	private void mostraResultado(TelaPontosPorFuncao telaPontosPorFuncao) {
		JLabel label = new JLabel("<html><div style='text-align: center;'>A quantidade de pontos por função no diretório informado é  : <br><font color='green'>" + pontosTotais + "</font></div></html>");
		label.setFont(new Font ("SansSerif", Font.BOLD, 15));
//		TODO:mudar tamanhoo da fonte do resultado
		JOptionPane.showMessageDialog(null, label, "Pronto", JOptionPane.INFORMATION_MESSAGE);
	}

	private void verificaPontos(String linha) {

		if (linha.contains(ALI_BAIXA)) {
			pontosTotais = pontosTotais.add(new BigInteger("7"));

		} else if (linha.contains(ALI_MEDIA)) {
			pontosTotais = pontosTotais.add(new BigInteger("10"));
			
		} else if (linha.contains(ALI_ALTA)) {
			pontosTotais = pontosTotais.add(new BigInteger("15"));
			
		} else if (linha.contains(AIE_BAIXA)) {
			pontosTotais = pontosTotais.add(new BigInteger("5"));
			
		} else if (linha.contains(AIE_MEDIA)) {
			pontosTotais = pontosTotais.add(new BigInteger("7"));
			
		} else if (linha.contains(AIE_ALTA)) {
			pontosTotais = pontosTotais.add(new BigInteger("10"));
			
		} else if (linha.contains(IE_BAIXA)) {
			pontosTotais = pontosTotais.add(new BigInteger("3"));
			
		} else if (linha.contains(IE_MEDIA)) {
			pontosTotais = pontosTotais.add(new BigInteger("4"));
			
		} else if (linha.contains(IE_ALTA)) {
			pontosTotais = pontosTotais.add(new BigInteger("6"));
			
		} else if (linha.contains(OE_BAIXA)) {
			pontosTotais = pontosTotais.add(new BigInteger("4"));
			
		} else if (linha.contains(OE_MEDIA)) {
			pontosTotais = pontosTotais.add(new BigInteger("5"));
			
		} else if (linha.contains(OE_ALTA)) {
			pontosTotais = pontosTotais.add(new BigInteger("7"));
			
		} else if (linha.contains(CE_BAIXA)) {
			pontosTotais = pontosTotais.add(new BigInteger("3"));
			
		} else if (linha.contains(CE_MEDIA)) {
			pontosTotais = pontosTotais.add(new BigInteger("4"));
			
		} else if (linha.contains(CE_ALTA)) {
			pontosTotais = pontosTotais.add(new BigInteger("6"));
			
		}
	}

	private void configuracoesDaTela() {

		this.setTitle("Calculadora de pontos por função v1.1");
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setSize(450, 270);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
	}

}
