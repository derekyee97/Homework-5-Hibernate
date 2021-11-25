package Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="order_detail")
public class OrderDetail 
{
	@Column(name="orderid")
	private int id;
	
	@Column(name="productid")
	private int productID;
	
	public OrderDetail(int orderID,int productID)
	{
		id=orderID;
		this.productID=productID;
	}
	public OrderDetail()
	{
		
	}
	public int getOrderID()
	{
		return id;
	}
	public int getProductID()
	{
		return productID;
	}
}
