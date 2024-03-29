package br.com.alura.escola.academico.infra.student;

import java.util.ArrayList;
import java.util.List;

import br.com.alura.escola.academico.domain.student.CPF;
import br.com.alura.escola.academico.domain.student.Student;
import br.com.alura.escola.academico.domain.student.StudentRepository;

public class RepositoryStudentInMemory implements StudentRepository {
	
	private List<Student> students = new ArrayList<Student>();

	@Override
	public void enroll(Student student) {
		this.students.add(student);
	}

	@Override
	public Student findByCPF(CPF cpf) {
		return this.students.stream()
				.filter(s -> s.getCpf().equalsIgnoreCase(cpf.getCpf()))
				.findFirst()
				.orElseThrow(()-> new IllegalArgumentException());
	}

	@Override
	public List<Student> listAll() {
		return this.students;
	}

}
