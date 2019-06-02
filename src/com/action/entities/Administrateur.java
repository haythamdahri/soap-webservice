package com.action.entities;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(namespace = "http://www.prix-action.ma", name="administrateur")
@XmlAccessorType(XmlAccessType.FIELD)
public class Administrateur implements Serializable {
	
	@XmlAttribute(namespace = "http://www.prix-action.ma", required = true, name = "id")
	@XmlID
	private String id;
	
	@XmlElement(namespace = "http://www.prix-action.ma", name = "firstName", required = true)
	private String firstName;
	
	@XmlElement(namespace = "http://www.prix-action.ma", name = "lastName", required = true)
	private String lastName;
	
	@XmlElement(namespace = "http://www.prix-action.ma", name = "email", required = true)
	private String email;
	
	@XmlElement(namespace = "http://www.prix-action.ma", name = "password", required = true)
	private String password;
	
	public Administrateur() {
		super();
	}

	public Administrateur(String id, String firstName, String lastName, String email, String password) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Administrateur [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + "]";
	}
	
	
	
}
