package br.com.alura.java.io.teste;

import java.io.FileWriter;
import java.io.IOException;

public class TesteEscritaMelhorado {

	public static void main(String[] args) throws IOException {
		
		FileWriter fw = new FileWriter("escrita2.txt");
		fw.write("Linha texto 1");
		fw.write(System.lineSeparator());//cria o /n ou /r/n de acordo com o sistema operacional
		fw.write(System.lineSeparator());
		fw.write("Linha texto 2");
		
		fw.close();
		
		
		//Opção 2 usando BufferedWriter para auxiliar na quebra de linha
//		BufferedWriter bw = new BufferedWriter(new FileWriter("escrita3.txt"));
//		bw.write("NO DOUBT");
//		bw.newLine();
//		bw.newLine();
//		bw.write("DON'T SPEAK");
//		
//		bw.close();

	}

}
