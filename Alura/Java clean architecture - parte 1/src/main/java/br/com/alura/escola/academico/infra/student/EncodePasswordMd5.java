package br.com.alura.escola.academico.infra.student;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import br.com.alura.escola.academico.domain.student.EncodePassword;

public class EncodePasswordMd5 implements EncodePassword {

	@Override
	public String encodePassword(String password) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(password.getBytes());
			byte[] bytes = md.digest();
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < bytes.length; i++) {
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}
			return sb.toString();
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException("Fail to generate hash password erro");
		}
	}

	@Override
	public boolean validationEncodePassword(String password, String passwordEncode) {
		return passwordEncode.equalsIgnoreCase(encodePassword(password));
	}

}
