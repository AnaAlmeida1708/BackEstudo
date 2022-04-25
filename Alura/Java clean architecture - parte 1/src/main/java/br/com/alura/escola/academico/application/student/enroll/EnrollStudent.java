package br.com.alura.escola.academico.application.student.enroll;

import br.com.alura.escola.academico.domain.PublicEvents;
import br.com.alura.escola.academico.domain.StudentEnroll;
import br.com.alura.escola.academico.domain.student.CPF;
import br.com.alura.escola.academico.domain.student.Student;
import br.com.alura.escola.academico.domain.student.StudentRepository;

public class EnrollStudent {
	
	private final StudentRepository repository;
	private final PublicEvents publicEvents;

	public EnrollStudent(StudentRepository repository, PublicEvents publicEvents) {
		this.repository = repository;
		this.publicEvents = publicEvents;
	}
	
	public void execute(EnrollStudentDTO dto) {
		Student newStudent = dto.createStudent();
		repository.enroll(newStudent);
		publicEvents.process(new StudentEnroll(new CPF(newStudent.getCpf())));
	}

}
