package pacote;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;

public class ArquivoBinario{

	public static void processaArquivo(DTOArquivo arquivo)
			throws IOException, SQLException {
		
		BufferedOutputStream bufferArquivoSaida = null;
		try {
			File arquivoSaida = new File(arquivo.caminhoArquivoSaida.getPath() +"\\Binario_"+ arquivo.arquivoEntrada.getName());
			bufferArquivoSaida = new BufferedOutputStream(new FileOutputStream(arquivoSaida));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		try (BufferedReader br = new BufferedReader(new FileReader(arquivo.arquivoEntrada))) {
		    String line;
		    bufferArquivoSaida.write(br.readLine().getBytes(arquivo.encoding));
		    bufferArquivoSaida.write(arquivo.diferencaLinhaHeader);
		    
		    while ((line = br.readLine()) != null) {
		    	bufferArquivoSaida.write(line.getBytes(arquivo.encoding));
		    	bufferArquivoSaida.write(arquivo.tamanhoImagem);
		    }
		    bufferArquivoSaida.flush();
			bufferArquivoSaida.close();
		}
	}
}
