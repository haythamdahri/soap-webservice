package com.action.entities;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement(namespace = "http://www.prix-action.ma", name = "action")
@XmlAccessorType(XmlAccessType.FIELD)
//@XmlType(propOrder = { "name", "openingAmount", "closingAmount", "date", "variation", "bourse" })
public class Action implements Serializable {

	@XmlAttribute(namespace = "http://www.prix-action.ma", required = true, name = "id")
	@XmlID
	private String id;

	@XmlElement(namespace = "http://www.prix-action.ma", name = "name", required = true)
	private String name;

	@XmlElement(namespace = "http://www.prix-action.ma", name = "openingAmount", required = true)
	private double openingAmount;

	@XmlElement(namespace = "http://www.prix-action.ma", name = "closingAmount", required = true)
	private double closingAmount;

	@XmlElement(namespace = "http://www.prix-action.ma", name = "date", required = true, type = Date.class)
	@XmlJavaTypeAdapter(DateAdapter.class)
	private Date date;

	@XmlElement(namespace = "http://www.prix-action.ma", name = "variation", required = true)
	private double variation;

	@XmlElement(namespace = "http://www.prix-action.ma", name = "bourse", required = true)
	private Long bourseId;
	
	public Action() {

	}

	public Action(String id, String name, double openingAmount, double closingAmount, Date date, Long bourseId) {
		super();
		this.id = id;
		this.name = name;
		this.openingAmount = openingAmount;
		this.closingAmount = closingAmount;
		this.date = date;
		
		double perecentage = ((100 * this.closingAmount) / this.openingAmount) - 100;
		NumberFormat formatter = new DecimalFormat("#0.00");
		String newPercentage = formatter.format(perecentage);
		System.out.println("Variation: ==> " + newPercentage);
		this.variation = Double.parseDouble(newPercentage);
		
		this.bourseId = bourseId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getOpeningAmount() {
		return openingAmount;
	}

	public void setOpeningAmount(double openingAmount) {
		this.openingAmount = openingAmount;
	}

	public double getClosingAmount() {
		return closingAmount;
	}

	public void setClosingAmount(double closingAmount) {
		this.closingAmount = closingAmount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getVariation() {
		return variation;
	}

	public void setVariation(double variation) {
		this.variation = variation;
	}

	public Long getBourseId() {
		return bourseId;
	}

	public void setBourseId(Long bourseId) {
		this.bourseId = bourseId;
	}

	@Override
	public String toString() {
		return "Action [id=" + id + ", name=" + name + ", openingAmount=" + openingAmount + ", closingAmount="
				+ closingAmount + ", date=" + date + ", variation=" + variation + ", bourse id=" + bourseId + "]";
	}

}
