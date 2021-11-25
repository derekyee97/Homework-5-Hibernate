package Entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customerorder")
public class Order
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="orderid")
	private int id;
	
	@Column(name="date")
	private Date date;
	
	@Column(name="costumer_name")
	private String name;
	
	public Order(String name, Date date)
	{
		this.name=name;
		this.date=date;
	}
	public Order()
	{
		
	}
	public Date getDate()
	{
		return date;
	}
	public int getOrderID()
	{
		return id;
	}
	public String getCostumerName()
	{
		return name;
	}
	
}
