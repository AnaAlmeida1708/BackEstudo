package br.com.alura.escola.application.student.enroll;

import br.com.alura.escola.domain.student.Student;
import br.com.alura.escola.domain.student.StudentRepository;

public class EnrollStudent {
	
	private final StudentRepository repository;

	public EnrollStudent(StudentRepository repository) {
		this.repository = repository;
	}
	
	public void execute(EnrollStudentDTO dto) {
		Student newStudent = dto.createStudent();
		repository.enroll(newStudent);
	}

}
