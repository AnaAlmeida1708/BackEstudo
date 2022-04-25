package br.com.alura.escola.academico.application.recommendation;

import br.com.alura.escola.academico.domain.student.Student;

public interface SendEmailToRecommendation {
	
	void sendEmailTo(Student indicated);

}
