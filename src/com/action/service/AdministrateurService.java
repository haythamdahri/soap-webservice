package com.action.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.action.entities.Administrateur;

/*
 *  Service class
 *  Annotation are optional when using eclipse
 */
public class AdministrateurService {

	public Administrateur getAdministrateur(Long id) {
		return new Administrateur(String.valueOf(id), "HAYTHAM", "DAHRI", "haytham.dahri@gmail.com", "toortoor");
	}

	public String hashPassword(String clairText) {

		try {
			// Create MessageDigest instance for MD5
			MessageDigest md;
			md = MessageDigest.getInstance("MD5");

			// Add password bytes to digest
			md.update(clairText.getBytes());

			// Get the hash's bytes
			byte[] bytes = md.digest();

			// This bytes[] has bytes in decimal format;
			// Convert it to hexadecimal format
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < bytes.length; i++) {
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}

			// Get complete hashed password in hex format
			String generatedPassword = sb.toString();

			// Return the generated Password
			return generatedPassword;

		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

}
