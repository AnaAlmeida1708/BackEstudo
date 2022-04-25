package br.com.alura.escola.academico.domain.student;

public interface EncodePassword {
	
	String encodePassword(String password);
	
	boolean validationEncodePassword(String password, String passwordEncode);

}
