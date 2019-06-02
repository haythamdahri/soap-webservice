package com.action.entities;

import java.util.Collection;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(namespace = "http://www.prix-action.ma", name="bourses")
@XmlAccessorType(XmlAccessType.FIELD)
public class Bourses {
	
	@XmlElementWrapper(name = "listeBourses") 
	@XmlElement(name = "bourse")
	private Collection<Bourse> bourses;

	public Bourses() {
		
	}
	
	public Bourses(Collection<Bourse> bourses) {
		this.bourses = bourses;
	}

	public Collection<Bourse> getBourses() {
		return bourses;
	}

	public void setBourses(Collection<Bourse> bourses) {
		this.bourses = bourses;
	}

	@Override
	public String toString() {
		return "Bourses [bourses=" + bourses + "]";
	}
	
	
}
