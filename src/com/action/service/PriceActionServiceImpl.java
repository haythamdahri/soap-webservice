package com.action.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;

import javax.xml.bind.DatatypeConverter;

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
	public boolean addBourse(Bourse bourse) {

		// Persist bourse into database
		return this.bourseDao.add(bourse);

	}

	@Override
	public String getActionHistory(String name) {
		// Fetch bourses from database
		Actions actions = new Actions(this.actionDao.findByName(name));

		// parse object into xml
		String xmlBoursesContent = ObjectXmlConverter.jaxbObjectToXMLActions(actions);

		// Return xml results
		return xmlBoursesContent;
	}

	@Override
	public boolean updateBourse(Bourse bourse) {
		return this.bourseDao.update(bourse);
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
	public boolean isValidAdmin(String email, String password) {
		try {

			// Hash clair password
			MessageDigest md = MessageDigest.getInstance("MD5");
			System.out.println("Password: " + password);
		    md.update(password.getBytes());
		    byte[] digest = md.digest();
		    String passwordHash = DatatypeConverter.printHexBinary(digest);
		    
		    // Fetch admin from database
			Administrateur administrateur = this.administrateurDao.find(email, passwordHash);
			
			return administrateur != null ? true :false;
			
		} 
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
	@Override
	public String getAdmin(Long id) {
		// Fetch admin from database
		Administrateur administrateur = this.administrateurDao.find(id);

		// parse object into xml
		String xmlActionsContent = ObjectXmlConverter.jaxbObjectToXMLAdmin(administrateur);

		// Return xml results
		return xmlActionsContent;
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
