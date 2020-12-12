import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OrdenaStrings {

	public static void main(String[] args) {
		
		List<String> palavras = new ArrayList<>();
		palavras.addAll(Arrays.asList("alura online", "editora casa do c�digo", "caelum"));
		
		palavras.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));
		palavras.sort((s1, s2) -> s1.length() - s2.length());//outra op��o omitindo o m�todo compare
		System.out.println(palavras);


//		palavras.forEach(new Consumer<String>() {
//			@Override
//			public void accept(String s) {
//				System.out.println(s);
//			}
//		});


//		Consumer<String> impressor = s -> System.out.println(s);
//		palavras.forEach(impressor);

		
		// mesmo coisa que os c�digos acima, mas usando lambda
		palavras.forEach(s -> System.out.println(s));

		
//		new Thread(new Runnable() {
//
//		    @Override
//		    public void run() {
//		        System.out.println("Executando um Runnable");
//		    }
//
//		}).start();
		
		// mesmo coisa do c�digo acima, mas usando lambda
		new Thread(()-> System.out.println("Executando um Runnable")).start();

	}
	

}
