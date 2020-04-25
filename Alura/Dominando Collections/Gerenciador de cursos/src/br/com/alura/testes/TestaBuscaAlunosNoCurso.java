package br.com.alura.testes;

public class TestaBuscaAlunosNoCurso {
	
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
		
		System.out.println("Quem � o aluno da matr�cula 456 ?");
		Aluno aluno = javaColecoes.buscaPorMatricula(456);
		System.out.println("Aluno: " + aluno);
		
	}
	

}
