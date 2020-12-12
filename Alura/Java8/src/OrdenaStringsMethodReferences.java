import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class OrdenaStringsMethodReferences {
	
	public static void main(String[] args) {
		
		List<String> palavras = new ArrayList<>();
		palavras.addAll(Arrays.asList("alura online", "editora casa do código", "caelum"));
		
		System.out.println("--------------- Básico------------------");
		//LAMBDA
		//palavras.sort(Comparator.comparing(s -> s.length()));
		//METHOD REFERENCE
		//palavras.sort(Comparator.comparing(String :: length)); 
		//palavras.sort(Comparator.comparing(String :: hashCode));
		palavras.sort((String.CASE_INSENSITIVE_ORDER));
		
		palavras.forEach(System.out::println);
		
		System.out.println("---------------Detalhado------------------");
		//Mesma coisa de cima, porém de forma detalhada
		Function<String, Integer> funcao = s -> s.length();
		Comparator<String> comparador = Comparator.comparing(funcao);
		palavras.sort(comparador);
		
		palavras.forEach(s -> System.out.println(s));
		
	}

}
