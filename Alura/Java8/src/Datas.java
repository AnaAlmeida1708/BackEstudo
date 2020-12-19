import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Datas {
	
	public static void main(String[] args) {
		
		LocalDate hoje = LocalDate.now();
		System.out.println(hoje);
		
		LocalDate futuro = LocalDate.of(2099, 1, 25);
		System.out.println(futuro);
		
		LocalDate futuro2 = LocalDate.of(2099, Month.JANUARY, 25 );
		System.out.println(futuro2);
		
		Period periodo = Period.between(futuro, hoje);
		System.out.println(periodo);
		
		DateTimeFormatter  formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		String hojeFormatado = hoje.format(formatter);
		System.out.println(hojeFormatado);
		
	}
}	
