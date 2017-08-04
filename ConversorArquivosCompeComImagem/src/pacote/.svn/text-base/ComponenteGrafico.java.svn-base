package pacote;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class ComponenteGrafico {

	public static File informaCaminhoEntrada() {
		JFileChooser chooser = new JFileChooser(); 
	    chooser.setDialogTitle("Informe o arquivo de entrada:");
	    chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

	    if (chooser.showOpenDialog(chooser) == JFileChooser.APPROVE_OPTION) { 
	    	return chooser.getSelectedFile();
	      }
	    else {
	    	return new File(System.getProperty("user.desktop"));
	    }	
	}
		
	public static File informaCaminhoSaida(File caminhoInicial) {
		File retorno = caminhoInicial;
		
		JFileChooser chooser = new JFileChooser(caminhoInicial); 
	    chooser.setDialogTitle("Informe o diretório de saída");
	    chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
	    chooser.setAcceptAllFileFilterUsed(false);

	    if (chooser.showOpenDialog(chooser) == JFileChooser.APPROVE_OPTION) { 
	    	retorno = chooser.getSelectedFile();
	      }
	    else {
	      System.out.println("Nenhum caminho selecionado, o padrão será: " + caminhoInicial.getName());
	   }
	
	    return retorno;
	}
	
	public static LayoutCompe selecionaConversor(){
		int tipoRetorno;
		int tipoArquivo = selecionaTipoArquivo();

		if(tipoArquivo == 0){
			tipoRetorno = selecionaTipoOperacao();
			return tipoRetorno == 0 ? new CelNraParaAscii() : new CelNraParaBinario();
		}else{
			tipoRetorno = selecionaTipoOperacao();
			if(tipoRetorno ==2){
				tipoRetorno = selecionaTipoDAD();
				return tipoRetorno == 0 ? new Dad604Para614() : new Dad606Para616();
			}else{
				return tipoRetorno == 0 ? new DadParaAscii() : new DadParaBinario();	
			}
		}
	}
	
	public static Integer selecionaTipoArquivo(){
		String opcoes[]={"CEL/NRA", "DAD"};

		int opcao=JOptionPane.showOptionDialog(null, "Escolha o Layout", 
		"Conversor de arquivos Compe com Imagem", 0, JOptionPane.INFORMATION_MESSAGE, null, 
		opcoes, opcoes[0]);
		
		return opcao;
	}
	public static Integer selecionaTipoOperacao(){
		String opcoes[]={"Binario Para ASCII", "ASCII Para Binário", "Binário Para Binário"};

		int opcao=JOptionPane.showOptionDialog(null, "Escolha o tipo de Operação", 
		"Conversor de arquivos Compe com Imagem", 0, JOptionPane.INFORMATION_MESSAGE, null, 
		opcoes, opcoes[0]);
		
		return opcao;
	}
	public static Integer selecionaTipoDAD(){
		String opcoes[]={"604 Para 614", "606 Para 616"};

		int opcao=JOptionPane.showOptionDialog(null, "Escolha o tipo de Operação", 
		"Conversor de arquivos Compe com Imagem", 0, JOptionPane.INFORMATION_MESSAGE, null, 
		opcoes, opcoes[0]);
		
		return opcao;
	}
}
