package br.com.alura.escola.academico.domain.student;

public class BuilderStudent {
	
	private Student student;
	
	public void withNameCPFEmail(String name, String cpf, String email) {
		this.student = new Student(name, new CPF(cpf), new Email(email));
	}
	
	public void withPhone(String ddd, String number) {
		this.student.addPhone(ddd, number);
	}
	
	public Student create() {
		return this.student;
	}

}
