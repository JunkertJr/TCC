package TCC;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Vector;
import java.util.zip.GZIPOutputStream;

public class LeitorArquivo {
	
	public static void main(String[] args) throws IOException {
		
		
		long inicio = System.currentTimeMillis();
		
		File diretorioArquivos = new File("d:/arquivos");
		File[] arquivos = diretorioArquivos.listFiles();		
		for (File file : arquivos) {
			//System.out.println(file.getCanonicalPath());
			
			InputStream input = new FileInputStream(file);
			input = new BufferedInputStream(input);
			
			OutputStream output = new FileOutputStream(file.getCanonicalPath() + ".gzip");
			output = new GZIPOutputStream(output);
			output = new BufferedOutputStream(output);
			
			int dado = 0;
			while ((dado = input.read()) != -1) {
				output.write(dado);
			}
			output.close();
			input.close();
		}
		System.out.println("Tempo total: " + (System.currentTimeMillis()-inicio));
	}
		
	public static File[] buscaArquivoDoDiretorio(File diretorio) {
		Vector vetor = new Vector();
		File[] files = diretorio.listFiles();
		for (int i = 0; i < files.length; i++) {
			if (files[i].isDirectory()) {
				File[] recFiles = buscaArquivoDoDiretorio(files[i]);
				for (int j = 0; j < recFiles.length; j++) {
					vetor.addElement(recFiles[j]);
				}
			} else {
				vetor.addElement(files[i]);
			}
		}
		
		File[] encontrados = new File[vetor.size()];
		for (int i = 0; i < vetor.size(); i++) {
			encontrados[i] = (File)vetor.elementAt(i);
		}
		return encontrados;
	}
		
}
