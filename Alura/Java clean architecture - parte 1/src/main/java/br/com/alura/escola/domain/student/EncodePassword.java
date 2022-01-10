package br.com.alura.escola.domain.student;

public interface EncodePassword {
	
	String encodePassword(String password);
	
	boolean validationEncodePassword(String password, String passwordEncode);

}
