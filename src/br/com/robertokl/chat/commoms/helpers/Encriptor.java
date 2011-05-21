package br.com.robertokl.chat.commoms.helpers;

import org.jasypt.util.text.BasicTextEncryptor;

public class Encriptor {
	public static String encode(String key, String text) {
		BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
		textEncryptor.setPassword(key);
		return textEncryptor.encrypt(text);
	}
	
	public static String decode(String key, String text) {
		BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
		textEncryptor.setPassword(key);
		return textEncryptor.decrypt(text);
	}
}
