package br.com.alura.validacao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class Data {
	
	public static void main(String[] args) {
		
		LocalDate hoje = LocalDate.now();
		System.out.println(hoje);
		LocalDateTime agora = LocalDateTime.now();
		System.out.println(agora);
		
		//Passando um pattern
		
		DateTimeFormatter dtfData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		System.out.println(hoje.format(dtfData));
		
		DateTimeFormatter dtfDataHora = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss");
		System.out.println(agora.format(dtfDataHora));
		
		//Usando ofLocalizedDateTime
		System.out.println(hoje.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)));
		System.out.println(hoje.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)));
		System.out.println(hoje.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).withLocale(Locale.CANADA)));
		
		System.out.println(agora.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT)));
		System.out.println(agora.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)));
		System.out.println(agora.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).withLocale(new Locale("pt", "BR"))));
		System.out.println(agora.minusHours(5).format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)));
		System.out.println(agora.minusHours(5).format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).withLocale(new Locale("pt", "BR"))));
	}

}
