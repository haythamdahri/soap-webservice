package com.action.dao;

import java.util.Collection;

import com.action.entities.Administrateur;

public interface AdministrateurDao {
	
	public void add(Administrateur administrateur);
	public Administrateur find(Long id);
	public Administrateur find(String email, String password);
	public Collection<Administrateur> findAll();
	public boolean update(Administrateur administrateur);
	public boolean delete(Long id);

}
