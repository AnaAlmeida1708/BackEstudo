package br.com.alura.escola.domain.student;

import java.util.List;

public interface StudentRepository {
	
	void matricular(Student student);
	
	Student findByCPF(CPF cpf);
	
	List<Student> listAll();
	
	//...

}
