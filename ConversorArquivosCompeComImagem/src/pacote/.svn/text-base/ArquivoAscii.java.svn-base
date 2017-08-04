package pacote;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;

public class ArquivoAscii {

	public static void processaArquivo(DTOArquivo arquivo)
			throws IOException, SQLException {
		
		BufferedInputStream bufferArquivoEntrada = new BufferedInputStream(new FileInputStream(arquivo.arquivoEntrada));
		bufferArquivoEntrada.read(arquivo.tamanhoHeader); 
		String text = new String(arquivo.tamanhoHeader, arquivo.encoding);
		
		File arquivoEntradaComNomeComposto = new File(arquivo.caminhoArquivoSaida.getPath() +"\\ASCII_"+ arquivo.arquivoEntrada.getName());
		FileWriter arquivoSaida = new FileWriter(arquivoEntradaComNomeComposto);
		arquivoSaida.write(text);
		arquivoSaida.write("\n");
		
		bufferArquivoEntrada.read(arquivo.diferencaLinhaHeader);
		
		while (bufferArquivoEntrada.read(arquivo.tamanhoTexto) != -1) {
			text = new String(arquivo.tamanhoTexto, arquivo.encoding);
			arquivoSaida.write(text);
			arquivoSaida.write("\n");
			bufferArquivoEntrada.read(arquivo.tamanhoImagem);
			
//			BufferedOutputStream arquivoImagemSaida = new BufferedOutputStream(new FileOutputStream(  
//					arquivo.caminhoArquivoSaida.getPath()+"\\chequeReferenteLinha_"+contador+".jpg"));
//			
//			arquivoImagemSaida.write(arquivo.tamanhoImagem);
//			arquivoImagemSaida.flush();
//			arquivoImagemSaida.close();
		}
		
		arquivoSaida.flush();
		arquivoSaida.close();
		bufferArquivoEntrada.close();
	}
}
