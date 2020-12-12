import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OrdenaStrings {

	public static void main(String[] args) {
		
		List<String> palavras = new ArrayList<>();
		palavras.addAll(Arrays.asList("alura online", "editora casa do código", "caelum"));
		
		palavras.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));
		palavras.sort((s1, s2) -> s1.length() - s2.length());//outra opção omitindo o método compare
		System.out.println(palavras);


//		palavras.forEach(new Consumer<String>() {
//			@Override
//			public void accept(String s) {
//				System.out.println(s);
//			}
//		});


//		Consumer<String> impressor = s -> System.out.println(s);
//		palavras.forEach(impressor);

		
		// mesmo coisa que os códigos acima, mas usando lambda
		palavras.forEach(s -> System.out.println(s));

		
//		new Thread(new Runnable() {
//
//		    @Override
//		    public void run() {
//		        System.out.println("Executando um Runnable");
//		    }
//
//		}).start();
		
		// mesmo coisa do código acima, mas usando lambda
		new Thread(()-> System.out.println("Executando um Runnable")).start();

	}
	

}
