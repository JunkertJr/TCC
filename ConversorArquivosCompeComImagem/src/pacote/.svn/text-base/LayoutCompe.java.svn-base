package pacote;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

public abstract class LayoutCompe {
	
	static byte[] tamanhoHeader = new byte[160];
	static byte[] diferencaLinhaHeader = new byte[27435];
	static byte[] diferencaLinhaHeader185 = new byte[27617];
	static byte[] pos12 = new byte[12];
	static byte[] tamanhoTexto = new byte[240];
	static byte[] tamanhoImagem = new byte[27408];
	static byte[] tamanhoLinha = new byte[27648];
	static String encoding = "Cp1047";
	
	abstract void processaArquivo(File arquivoEntrada, File caminhoArquivoSaida)
			throws IOException, SQLException;

}
