package com.action.service;

import java.util.Collection;

import com.action.dao.ActionDao;
import com.action.dao.ActionDaoImpl;
import com.action.dao.AdministrateurDao;
import com.action.dao.AdministrateurDaoImpl;
import com.action.dao.BourseDao;
import com.action.dao.BourseDaoImpl;
import com.action.entities.Action;
import com.action.entities.Actions;
import com.action.entities.Administrateur;
import com.action.entities.Bourse;
import com.action.entities.Bourses;

public class PriceActionServiceImpl implements PriceActionService {

	private ActionDao actionDao = new ActionDaoImpl();
	private BourseDao bourseDao = new BourseDaoImpl();
	private AdministrateurDao administrateurDao = new AdministrateurDaoImpl();

	// Return bourse xml content
	@Override
	public String getBourse(Long id) {
				
		// Fetch bourse from database
		Bourse bourse = this.bourseDao.find(id);
		// parse object into xml
		String xmlBourseContent = ObjectXmlConverter.jaxbObjectToXMLBourse(bourse);

		// Return xml results
		return xmlBourseContent;
	}

	@Override
	public String getBourses() {
		
		// Fetch bourses from database
		Bourses bourses = new Bourses(this.bourseDao.findAll());

		// parse object into xml
		String xmlBoursesContent = ObjectXmlConverter.jaxbObjectToXMLBourses(bourses);

		// Return xml results
		return xmlBoursesContent;
	}
	
	@Override
	public String getBoursesById(Long id) {
		
		// Fetch bourses from database
		Bourses bourses = new Bourses(this.bourseDao.findById(id));

		// parse object into xml
		String xmlBoursesContent = ObjectXmlConverter.jaxbObjectToXMLBourses(bourses);

		// Return xml results
		return xmlBoursesContent;
	}

	@Override
	public boolean updateBourse(Bourse bourse) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteBourse(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getAction(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getActions() {
		// Fetch actions from database
		Actions actions = new Actions(this.actionDao.findAll());

		// parse object into xml
		String xmlActionsContent = ObjectXmlConverter.jaxbObjectToXMLActions(actions);

		// Return xml results
		return xmlActionsContent;
	}

	@Override
	public String getActionsByBourse(Long id) {
		// Fetch actions from database
		Actions actions = new Actions(this.actionDao.findByBourseId(id));

		// parse object into xml
		String xmlActionsContent = ObjectXmlConverter.jaxbObjectToXMLActions(actions);

		// Return xml results
		return xmlActionsContent;
	}

	@Override
	public boolean updateAction(Action action) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteAction(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getAdmin(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Administrateur> getAdmins() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateAdmin(Administrateur administrateur) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteAdmin(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

}
