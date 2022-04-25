package br.com.alura.escola.academico;

import java.util.List;

import br.com.alura.escola.academico.application.student.enroll.EnrollStudent;
import br.com.alura.escola.academico.application.student.enroll.EnrollStudentDTO;
import br.com.alura.escola.academico.domain.PublicEvents;
import br.com.alura.escola.academico.domain.student.LogStudentEnroll;
import br.com.alura.escola.academico.domain.student.Student;
import br.com.alura.escola.academico.infra.student.RepositoryStudentInMemory;

public class EnrollStudentCommand {

	public static void main(String[] args) {
		String name = "Higor do Carmo";
		String cpf = "169.104.750-38";
		String email = "higor@gmail.com";
		
		EnrollStudentDTO dto = new EnrollStudentDTO(name, cpf, email);
		
		RepositoryStudentInMemory inMemory = new RepositoryStudentInMemory();
		
		PublicEvents publicEvents = new PublicEvents();
		publicEvents.add( new LogStudentEnroll());
		
		EnrollStudent enrollStudent = new EnrollStudent(inMemory, publicEvents);
		enrollStudent.execute(dto);
		
		List<Student> students = inMemory.listAll();
		for (Student student2 : students) {
			System.out.println(student2.getName());
		}
	}

}
