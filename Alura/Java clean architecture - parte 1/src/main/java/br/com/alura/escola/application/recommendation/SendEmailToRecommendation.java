package br.com.alura.escola.application.recommendation;

import br.com.alura.escola.domain.student.Student;

public interface SendEmailToRecommendation {
	
	void sendEmailTo(Student indicated);

}
