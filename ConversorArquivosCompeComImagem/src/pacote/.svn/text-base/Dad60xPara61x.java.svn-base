package pacote;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

public abstract class Dad60xPara61x extends LayoutCompeDad{

	@Override
	public void processaArquivo(File arquivoEntrada, File caminhoArquivoSaida) throws IOException,SQLException {
		
		BufferedInputStream bufferArquivoEntrada = new BufferedInputStream(new FileInputStream(arquivoEntrada));
		BufferedOutputStream bufferArquivoSaida = null;
		BufferedInputStream bufferArquivoContador = new BufferedInputStream(new FileInputStream(arquivoEntrada));
		try {
			File arquivoSaida = new File(caminhoArquivoSaida.getPath() +"\\"+ buscaTipoDad() + "_" + arquivoEntrada.getName());
			bufferArquivoSaida = new BufferedOutputStream(new FileOutputStream(arquivoSaida));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		Integer totalLinhas = contaLinhas(bufferArquivoContador);
		montaHeaderETrailer(bufferArquivoEntrada, bufferArquivoSaida);
		
		for(int contador= 2;contador < totalLinhas-1;contador++){
			
			bufferArquivoEntrada.read(tamanhoTexto);
			bufferArquivoSaida.write(tamanhoTexto);
			
			bufferArquivoEntrada.read(tamanhoImagem);
			bufferArquivoSaida.write(tamanhoImagem);
			
			System.out.println(new String(tamanhoImagem, "Cp1047"));
		}
		
		montaHeaderETrailer(bufferArquivoEntrada, bufferArquivoSaida);
			
		bufferArquivoEntrada.close();
		bufferArquivoSaida.flush();
		bufferArquivoSaida.close();
	}

	public abstract String buscaTipoDad();

	private static Integer contaLinhas(BufferedInputStream bufferArquivoEntrada) {
		int contador = 1;
		try {
			while (bufferArquivoEntrada.read(tamanhoLinha) != -1) {
				contador++;
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return contador;
	}

	private void montaHeaderETrailer( BufferedInputStream bufferArquivoEntrada,	BufferedOutputStream bufferArquivoSaida) throws IOException,
	UnsupportedEncodingException {
		bufferArquivoEntrada.read(pos12);
		bufferArquivoSaida.write(pos12);

		bufferArquivoEntrada.read(new byte[19]);
		String valoresFixos = "DAD" + buscaTipoDad() + "     001EXEDF";

		bufferArquivoSaida.write(valoresFixos.getBytes(encoding));
		
		bufferArquivoEntrada.read(diferencaLinhaHeader185);
		bufferArquivoSaida.write(diferencaLinhaHeader185);		

	}
}
