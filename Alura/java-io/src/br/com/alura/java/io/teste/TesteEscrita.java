package br.com.alura.java.io.teste;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class TesteEscrita {

	public static void main(String[] args) throws IOException {
		
		FileOutputStream fso = new FileOutputStream("dont-speak2.txt");
		OutputStreamWriter osw = new OutputStreamWriter(fso);
		BufferedWriter bw = new BufferedWriter(osw);
		
		bw.write("NO DOUBT");
		bw.newLine();
		bw.newLine();
		bw.write("DON'T SPEAK");
		
		bw.close();

	}

}
