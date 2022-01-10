package br.com.alura.escola.domain.recommendation;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

import br.com.alura.escola.domain.student.Student;

public class Recommendation {
	
	private Student indicated;
	private Student  indicative;
	private LocalDateTime recommendationDate;
	
	public Recommendation(Student indicated, Student indicative) {
		this.indicated = indicated;
		this.indicative = indicative;
		this.recommendationDate = LocalDateTime.now();
	}
	
	public Student getIndicated() {
		return indicated;
	}
	
	public Student getIndicative() {
		return indicative;
	}
	
	public LocalDateTime getRecommendationDate() {
		return recommendationDate;
	}
	
	public static void main(String[] args) {
		LocalDateTime localDateHoje = LocalDateTime.of(2022, 01, 03, 0, 0, 0);
		System.out.println(localDateHoje);
		
		LocalDateTime ontem = LocalDateTime.of(2022, 01, 03, 9, 20);
		
		if(ontem.isBefore(localDateHoje)) {
			System.out.println(ontem);
		}
		
	}
}
