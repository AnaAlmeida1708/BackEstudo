package br.com.alura.escola.academico.infra.student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import br.com.alura.escola.academico.domain.student.CPF;
import br.com.alura.escola.academico.domain.student.Phone;
import br.com.alura.escola.academico.domain.student.Student;
import br.com.alura.escola.academico.domain.student.StudentRepository;

public class RepositoryStudentWithJDBC implements StudentRepository {
	
	private final Connection connection;
	
	public RepositoryStudentWithJDBC(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void enroll(Student student) {
		try {
			String sql = "INSERT INTO STUDENT (?, ? ?)";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, student.getCpf());
			ps.setString(2, student.getName());
			ps.setString(3, student.getEmail());
			ps.execute();
			
			sql = "INSERT INTO PHONE VALUES(?, ?)";
			ps = connection.prepareStatement(sql);
			for (Phone phone : student.getPhones()) {
				ps.setString(1, phone.getDdd());
				ps.setString(2, phone.getNumber());
				ps.execute();
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public Student findByCPF(CPF cpf) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
