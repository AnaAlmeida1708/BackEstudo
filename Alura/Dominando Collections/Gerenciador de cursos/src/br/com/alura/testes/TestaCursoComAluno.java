package br.com.alura.testes;

public class TestaCursoComAluno {

	public static void main(String[] args) {

		Curso javaColecoes = new Curso("Dominando as cole��es do Java", "Paulo Silveira");

		javaColecoes.adiciona(new Aula("Trabalhando com ArrayList", 21));
		javaColecoes.adiciona(new Aula("Criando uma aula", 20));
		javaColecoes.adiciona(new Aula("Modelando com cole��es", 24));

		Aluno a1 = new Aluno("Ana Almeida", 123);
		Aluno a2 = new Aluno("Fabio Ara�jo", 456);
		Aluno a3 = new Aluno("Higor do Carmo", 789);

		javaColecoes.matricula(a1);
		javaColecoes.matricula(a2);
		javaColecoes.matricula(a3);

//		System.out.println("Todos os alunos matr�culados:");
//		javaColecoes.getAlunos().forEach(aluno -> {System.out.println(aluno);});
		
		System.out.println("O " + a1 + " est� matriculado?");
		System.out.println(javaColecoes.estaMatriculado(a1));
		
		Aluno ana = new Aluno("Ana Almeida", 123);
		System.out.println("O " + ana + " est� matriculado?");
		System.out.println(javaColecoes.estaMatriculado(ana));
		
	}

}
