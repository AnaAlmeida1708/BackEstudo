package br.com.alura.escola.academico.application.student.enroll;

import br.com.alura.escola.academico.domain.student.BuilderStudent;
import br.com.alura.escola.academico.domain.student.Student;

public class EnrollStudentDTO {
	
	private String name;
	private String cpf;
	private String email;
	
	public EnrollStudentDTO(String name, String cpf, String email) {
		this.name = name;
		this.cpf = cpf;
		this.email = email;
	}
	
	public Student createStudent() {
		BuilderStudent student = new BuilderStudent();
		student.withNameCPFEmail(this.name, this.cpf, this.email);
		return student.create();
	}

}
