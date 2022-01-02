package br.com.alura.escola.model;

import java.time.LocalDateTime;

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
}
