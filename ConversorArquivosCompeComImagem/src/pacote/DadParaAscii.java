package pacote;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

public class DadParaAscii extends LayoutCompeDad{

	@Override
	public	void processaArquivo(File arquivoEntrada, File caminhoArquivoSaida)
			throws IOException, SQLException {
	
		DTOArquivo arquivo = new DTOArquivo(arquivoEntrada, caminhoArquivoSaida, encoding, tamanhoHeader, tamanhoTexto, diferencaLinhaHeader, tamanhoImagem);
		ArquivoAscii.processaArquivo(arquivo);
	}
}
