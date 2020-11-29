import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class OrdenaStrings {
	
	public static void main(String[] args) {
		List<String> palavras = new ArrayList<>();
		palavras.addAll(Arrays.asList("alura online", "editora casa do código", "caelum"));
		
//		Collections.sort(palavras); usando a classe comparable para ordenar
		Comparator<String> comparador = new ComparadorPorTamanho();
//		Collections.sort(palavras, comparador); usando a classe comparator para ordenar
		
		palavras.sort(comparador);
		System.out.println(palavras);
		
		//iterando antes do Java 8
//		for(String palavra: palavras) {
//			System.out.println(palavra);
//		}
		
		Consumer<String> consumidor = new ImprimiNaLinha();
		palavras.forEach(consumidor);
		
	}

}

class ImprimiNaLinha implements Consumer<String>{
	@Override
	public void accept(String s) {
		System.out.println(s);
	}
}

class ComparadorPorTamanho implements Comparator<String> {

	@Override
	public int compare(String s1, String s2) {
		if(s1.length() < s2.length()) {
			return -1;
		}
		if(s1.length() > s2.length()) {
			return 1;
		}
		return 0;
	}
	
}
