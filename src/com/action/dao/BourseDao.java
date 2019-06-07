package com.action.dao;

import java.util.Collection;

import com.action.entities.Bourse;

public interface BourseDao {
	
	public boolean add(Bourse bourse);
	public Bourse find(Long id);
	public Collection<Bourse> findById(Long id);
	public Collection<Bourse> findAll();
	public boolean update(Bourse bourse);
	public boolean delete(Long id);
	public Collection<Bourse> findActiveBourses();

}
