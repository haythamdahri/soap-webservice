package com.action.service;

import java.util.Collection;

import javax.jws.WebService;

import com.action.entities.Action;
import com.action.entities.Administrateur;
import com.action.entities.Bourse;

@WebService
public interface PriceActionService {

	public String getBourse(Long id);
	public String getBourses();
	public boolean addBourse(Bourse bourse);
	public String getBoursesById(Long id);
	public boolean updateBourse(Bourse bourse);
	public boolean deleteBourse(Long id);
	
	public String getAction(Long id);
	public String getActions();
	public boolean addAction(Action action);
	public String getActionHistory(String name);
	public String getActionsByBourse(Long id);
	public boolean updateAction(Action action);
	public boolean deleteAction(Long id);
	
	public String getAdmin(Long id);
	public boolean isValidAdmin(String email, String password);
	public Collection<Administrateur> getAdmins();
	public boolean updateAdmin(Administrateur administrateur);
	public boolean deleteAdmin(Long id);
	
}
