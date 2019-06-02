package com.action.dao;

import java.util.Collection;

import com.action.entities.Action;

public interface ActionDao {

	public void add(Action action);

	public Action find(Long id);
	
	public Collection<Action> findByName(String name);

	public Collection<Action> findById(Long id);
	
	public Collection<Action> findByBourseId(Long id);

	public Collection<Action> findAll();

	public boolean update(Action action);

	public boolean delete(Long id);

}
