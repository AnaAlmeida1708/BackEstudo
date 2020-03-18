package br.com.alura.java.io.teste;

import java.io.File;
import java.util.Locale;
import java.util.Scanner;

public class TesteEscritaComScanner {

	public static void main(String[] args) throws Exception {

		Scanner scanner = new Scanner(new File("contas.csv", "UTF-8"));

		while (scanner.hasNextLine()) {
			String linha = scanner.nextLine();
//			System.out.println(linha);
			
//			String[] valores = linha.split(",");
//			System.out.println(Arrays.toString(valores));
			
			Scanner linhaScanner = new Scanner(linha);
			linhaScanner.useLocale(Locale.US);//necessário usar para evitar erro pelo tipo de parse no tipo Double
			linhaScanner.useDelimiter(",");
			
			String tipoConta = linhaScanner.next();
			int agencia = linhaScanner.nextInt();
			int numero = linhaScanner.nextInt();
			String titular = linhaScanner.next();
			double saldo = linhaScanner.nextDouble();
			
//			System.out.println(valor1 + valor2 + valor3 + valor4 + valor5);
			
			String valorFormatado = String.format(new Locale("pt_BR"),"%s %04d %08d %s %.2f", tipoConta, agencia, numero, titular, saldo);
			//%s String %d inteiro %f float - para mais informações olhar documentação Formating numeric print
			System.out.println(valorFormatado);
			
			System.out.format("%s %04d %08d %s %.2f %n", tipoConta, agencia, numero, titular, saldo);
			
			linhaScanner.close();
		}

		scanner.close();
	}

}
