package com.action.entities;

import java.util.Collection;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(namespace = "http://www.prix-action.ma", name="administrateurs")
@XmlAccessorType(XmlAccessType.FIELD)
public class Administrateurs {

	@XmlElementWrapper(name = "listeAdmins") 
	@XmlElement(name = "administrateurs")
	private Collection<Administrateur> administrateurs;

	public Administrateurs() {
		super();
	}

	public Administrateurs(Collection<Administrateur> administrateurs) {
		super();
		this.administrateurs = administrateurs;
	}

	public Collection<Administrateur> getAdministrateurs() {
		return administrateurs;
	}

	public void setAdministrateurs(Collection<Administrateur> administrateurs) {
		this.administrateurs = administrateurs;
	}

	@Override
	public String toString() {
		return "Administrateurs [administrateurs=" + administrateurs + "]";
	}
	
	
}
