package br.com.alura.escola.domain.student;

public class BuilderStudent {
	
	private Student student;
	
	public void withNameCPFEmail(String name, String cpf, String email) {
		this.student = new Student(name, new CPF(cpf), new Email(email));
	}
	
	public void withPhone(String ddd, String number) {
		this.student.addPhone(ddd, number);
	}
	
	public Student criar() {
		return this.student;
	}

}
