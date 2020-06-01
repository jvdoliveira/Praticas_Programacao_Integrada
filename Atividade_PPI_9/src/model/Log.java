package model;

import java.io.*;

public class Log {
	public static final String NOME = "rastreamento.txt";
	private PrintWriter arquivo;

	public void abrir(String nome) throws IOException {
		File outFile = new File(nome);
		FileOutputStream outFileStream;

		System.out.println("Procure o arquivo em " + nome);
		if (outFile.exists()) {
			outFileStream = new FileOutputStream(outFile, true);
		} else {
			outFileStream = new FileOutputStream(outFile);
		}
		arquivo = new PrintWriter(outFileStream);
	}

	public void escrever(String texto) throws IOException {
		synchronized (arquivo) {
			arquivo.println(texto);
			arquivo.flush();
		}
	}

	public void fechar() throws IOException {
		synchronized (arquivo) {
			arquivo.close();
		}
	}
}
