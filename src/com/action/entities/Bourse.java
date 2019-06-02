package com.action.entities;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(namespace = "http://www.prix-action.ma", name="bourse")
@XmlAccessorType(XmlAccessType.FIELD)
public class Bourse implements Serializable {

	@XmlAttribute(namespace = "http://www.prix-action.ma", required = true, name = "id")
	@XmlID
	private String id;
	
	@XmlElement(namespace = "http://www.prix-action.ma", name = "name", required = true)
	private String name;
		
	public Bourse() {
		super();
	}

	public Bourse(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Bourse [id=" + id + ", name=" + name + "]";
	}

}
