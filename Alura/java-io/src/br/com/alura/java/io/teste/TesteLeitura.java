package br.com.alura.java.io.teste;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class TesteLeitura {
	
	public static void main (String [] args) throws IOException {
		
		FileInputStream fis = new FileInputStream("dont-speak.txt");
		InputStreamReader isr = new InputStreamReader(fis, "UTF-8");//Importante inserir o encode igual ao do arquivo para evitar erros na visualização
		BufferedReader br = new BufferedReader(isr);
		
		String linha = br.readLine();
		
		while (linha != null) {
			System.out.println(linha);
			linha = br.readLine();
			
		}
		br.close();
	}

}
