package br.com.alura.escola.model;

import java.util.ArrayList;
import java.util.List;

public class Student {
	
	//ENTITY
	
	private String name;
	private CPF cpf;
	private Email email;
	private List<Phone> phones = new ArrayList();
	
	public void addPhone(String ddd, String number) {
		this.phones.add(new Phone(ddd, number));
	}

	public Student(String name, CPF cpf, Email email) {
		this.name = name;
		this.cpf = cpf;
		this.email = email;
	}
	
	

}
