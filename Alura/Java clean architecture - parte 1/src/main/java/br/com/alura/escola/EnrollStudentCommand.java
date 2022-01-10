package br.com.alura.escola;

import java.util.List;

import br.com.alura.escola.application.student.enroll.EnrollStudent;
import br.com.alura.escola.application.student.enroll.EnrollStudentDTO;
import br.com.alura.escola.domain.student.CPF;
import br.com.alura.escola.domain.student.Email;
import br.com.alura.escola.domain.student.Student;
import br.com.alura.escola.infra.student.RepositoryStudentInMemory;

public class EnrollStudentCommand {

	public static void main(String[] args) {
		String name = "Higor do Carmo";
		String cpf = "169.104.750-38";
		String email = "higor@gmail.com";
		
		EnrollStudentDTO dto = new EnrollStudentDTO(name, cpf, email);
		
		RepositoryStudentInMemory inMemory = new RepositoryStudentInMemory();
		
		EnrollStudent enrollStudent = new EnrollStudent(inMemory);
		enrollStudent.execute(dto);
		
		List<Student> students = inMemory.listAll();
		for (Student student2 : students) {
			System.out.println(student2.getName());
		}
	}

}
