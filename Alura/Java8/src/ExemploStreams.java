import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

class Curso {
	private String nome;
	private int alunos;
	
	public Curso(String nome, int alunos) {
		this.nome = nome;
		this.alunos = alunos;
	}

	public String getNome() {
		return nome;
	}

	public int getAlunos() {
		return alunos;
	}
	
	
}


public class ExemploStreams {

	public static void main(String[] args) {
		
		List<Curso> cursos = new ArrayList<>();
		cursos.add(new Curso("Python", 45));
		cursos.add(new Curso("JavaScript", 150));
		cursos.add(new Curso("Java 8", 113));
		cursos.add(new Curso("C", 55));
		
		 cursos.sort(Comparator.comparing(Curso :: getAlunos));
		
		cursos.forEach(System.out:: println);
		cursos.forEach(c -> System.out.println(c.getNome()));
		
		 //FILTER
		 cursos.stream()
		 .filter(c -> c.getAlunos() >= 100)
		 .forEach(c -> System.out.println(c.getNome()));
		 
		 //FILTER MAP
		 cursos.stream()
		 .filter(c -> c.getAlunos() >= 100)
		 .map(Curso :: getAlunos)
		 .forEach(System.out :: println);
		 
		 //IntStream FILTER MapToInt
		 int soma = cursos.stream()
		 .filter(c -> c.getAlunos() >= 100)
		 .mapToInt(Curso:: getAlunos)
		 .sum();
		 
		 System.out.println(soma);
		 
		 Optional<Curso> optional = cursos.stream()
		 .filter(c -> c.getAlunos() > 50)
		 .findFirst();
		 Curso curso = optional.get();
		 System.out.println(curso.getNome().toString());
		 
		 OptionalDouble media = cursos.stream()
		    .mapToInt(c -> c.getAlunos())
		    .average();
		 
		 System.out.println(media);
		 
		 List<Curso> curs = cursos.stream()
				 .filter(c -> c.getAlunos() > 50)
				 .collect(Collectors.toList());
		 
		 curs.forEach(c -> System.out.println(c.getNome().toString()));
		 
	}

}
