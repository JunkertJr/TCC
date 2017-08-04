package pacote;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

public class DadParaBinario extends LayoutCompeDad {

	public void processaArquivo(File arquivoEntrada, File caminhoArquivoSaida)
	throws IOException, SQLException {
		DTOArquivo arquivo = new DTOArquivo(arquivoEntrada, caminhoArquivoSaida, encoding, diferencaLinhaHeader, tamanhoImagem);
		ArquivoBinario.processaArquivo(arquivo);
	}
}
