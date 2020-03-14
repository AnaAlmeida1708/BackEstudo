package br.com.alura.java.io.teste;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class TesteCopiarArquivo {
	
	public static void main (String [] args) throws IOException {
		
//		FileInputStream fis = new FileInputStream("dont-speak.txt");
		InputStream fis = System.in;
		InputStreamReader isr = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(isr);
		
		FileOutputStream fso = new FileOutputStream("dont-speak2.txt");
		OutputStreamWriter osw = new OutputStreamWriter(fso);
		BufferedWriter bw = new BufferedWriter(osw);
		
		String linha = br.readLine();
		
		while (linha != null && !linha.isEmpty()) {
			bw.write(linha);
			bw.newLine();
			linha = br.readLine();
			
		}
		br.close();
		bw.close();
	}

}
