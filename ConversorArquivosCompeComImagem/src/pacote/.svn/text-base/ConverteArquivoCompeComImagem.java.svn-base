package pacote;

import java.io.File;


public class ConverteArquivoCompeComImagem {
	
	public static void main(String[] args) {
		try {
			LayoutCompe tipoArquivo = ComponenteGrafico.selecionaConversor();
			File arquivoEntrada = ComponenteGrafico.informaCaminhoEntrada();
			File pathSaida = ComponenteGrafico.informaCaminhoSaida(arquivoEntrada);
			
			tipoArquivo.processaArquivo(arquivoEntrada, pathSaida);
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

}
