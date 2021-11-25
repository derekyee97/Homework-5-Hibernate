package Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Professor")
public class Professor 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="professorid")
	private int id;
	
	@Column(name="office_number")
	private String officeNumber;
	
	@Column(name="research_area")
	private String researchArea;
	
	@Column(name="customerid")
	private int customerID;
	
	public Professor(String officeNumber, String research, int customerID)
	{
		this.officeNumber=officeNumber;
		this.researchArea=research;
		this.customerID=customerID;
	}
	public Professor()
	{
		
	}
	public int getID()
	{
		return id;
	}
	public int getCustomerID()
	{
		return customerID;
	}
	public String getResearchArea()
	{
		return researchArea; 
	}
	public String getOfficeNumber()
	{
		return officeNumber;
	}
	
	
}
