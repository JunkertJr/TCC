package pacote;

import java.io.File;

public class DTOArquivo {

	File arquivoEntrada;
	File caminhoArquivoSaida;
	String encoding;
	byte[] tamanhoHeader;
	byte[] tamanhoTexto;
	byte[] diferencaLinhaHeader;
	byte[] tamanhoImagem;
	
	public DTOArquivo(File arquivoEntrada,File caminhoArquivoSaida,
						String encoding, byte[] diferencaLinhaHeader,
						byte[] tamanhoImagem){
		this.arquivoEntrada = arquivoEntrada;
		this.caminhoArquivoSaida = caminhoArquivoSaida;
		this.diferencaLinhaHeader = diferencaLinhaHeader;
		this.encoding = encoding;
		this.tamanhoImagem = tamanhoImagem;
	}
	
	public DTOArquivo(File arquivoEntrada,File caminhoArquivoSaida,
			String encoding, byte[] tamanhoHeader, byte[] tamanhoTexto,
			byte[] diferencaLinhaHeader, byte[] tamanhoImagem){
		this.arquivoEntrada = arquivoEntrada;
		this.caminhoArquivoSaida = caminhoArquivoSaida;
		this.encoding = encoding;
		this.tamanhoImagem = tamanhoImagem;
		this.tamanhoHeader = tamanhoHeader;
		this.tamanhoTexto = tamanhoTexto;
		this.diferencaLinhaHeader = diferencaLinhaHeader;
	}
}
