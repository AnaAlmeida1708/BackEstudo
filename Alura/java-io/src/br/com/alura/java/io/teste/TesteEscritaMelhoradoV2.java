package br.com.alura.java.io.teste;

import java.io.IOException;
import java.io.PrintStream;

public class TesteEscritaMelhoradoV2 {

	public static void main(String[] args) throws IOException {
		
		PrintStream ps = new PrintStream("escrita4.txt");
//		PrintWriter ps = new PrintWriter("escrita4.txt");//veio depois
		ps.println("linha texto 1");
		ps.println();
		ps.print("linha texto 2");
		
		ps.close();
		
	}

}
