package com.action.service;

import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.action.entities.Actions;
import com.action.entities.Administrateur;
import com.action.entities.Bourse;
import com.action.entities.Bourses;

public class ObjectXmlConverter {

	// Convert bourse object to XML format
	public static String jaxbObjectToXMLBourse(Bourse bourse) {

		if (bourse == null) {
			bourse = new Bourse();
		}

		try {
			// Create JAXB Context
			JAXBContext jaxbContext = JAXBContext.newInstance(Bourse.class);

			// Create Marshaller
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			// Required formatting??
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

			// Print XML String to Console
			StringWriter sw = new StringWriter();

			// Write XML to StringWriter
			jaxbMarshaller.marshal(bourse, sw);

			// Verify XML Content
			String xmlContent = sw.toString();

			// Return constructed xml object
			return xmlContent;

		} catch (JAXBException e) {
			e.printStackTrace();
			return null;
		}

	}

	// Convert collection of bourses object to XML format
	public static String jaxbObjectToXMLBourses(Bourses bourses) {
		if (bourses == null) {
			bourses = new Bourses();
		}

		try {
			// Create JAXB Context
			JAXBContext jaxbContext = JAXBContext.newInstance(Bourses.class);

			// Create Marshaller
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			// Required formatting??
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

			// Print XML String to Console
			StringWriter sw = new StringWriter();

			// Write XML to StringWriter
			jaxbMarshaller.marshal(bourses, sw);

			// Verify XML Content
			String xmlContent = sw.toString();

			// Return constructed xml object
			return xmlContent;

		} catch (JAXBException e) {
			e.printStackTrace();
			return null;
		}

	}

	// Convert collection of actions object to XML format
	public static String jaxbObjectToXMLActions(Actions actions) {

		if (actions == null) {
			actions = new Actions();
		}

		try {
			// Create JAXB Context
			JAXBContext jaxbContext = JAXBContext.newInstance(Actions.class);

			// Create Marshaller
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			// Required formatting??
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

			// Print XML String to Console
			StringWriter sw = new StringWriter();

			// Write XML to StringWriter
			jaxbMarshaller.marshal(actions, sw);

			// Verify XML Content
			String xmlContent = sw.toString();

			// Return constructed xml object
			return xmlContent;

		} catch (JAXBException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	// Convert administrator object to XML format
		public static String jaxbObjectToXMLAdmin(Administrateur admin) {

			if (admin == null) {
				admin = new Administrateur();
			}

			try {
				// Create JAXB Context
				JAXBContext jaxbContext = JAXBContext.newInstance(Administrateur.class);

				// Create Marshaller
				Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

				// Required formatting??
				jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

				// Print XML String to Console
				StringWriter sw = new StringWriter();

				// Write XML to StringWriter
				jaxbMarshaller.marshal(admin, sw);

				// Verify XML Content
				String xmlContent = sw.toString();

				// Return constructed xml object
				return xmlContent;

			} catch (JAXBException e) {
				e.printStackTrace();
				return null;
			}

		}

}
