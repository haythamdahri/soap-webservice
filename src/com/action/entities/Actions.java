package com.action.entities;

import java.util.Collection;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(namespace = "http://www.prix-action.ma", name="actions")
@XmlAccessorType(XmlAccessType.FIELD)
public class Actions {
	
	@XmlElementWrapper(name = "listeActions") 
	@XmlElement(name = "actions")
	private Collection<Action> actions;

	public Actions() {
		super();
	}

	public Actions(Collection<Action> actions) {
		super();
		this.actions = actions;
	}
	
	public Collection<Action> getActions() {
		return actions;
	}

	public void setActions(Collection<Action> actions) {
		this.actions = actions;
	}

	@Override
	public String toString() {
		return "Actions [actions=" + actions + "]";
	}
	
	

}
