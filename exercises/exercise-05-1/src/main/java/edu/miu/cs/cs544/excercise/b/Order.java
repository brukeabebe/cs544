package edu.miu.cs.cs544.excercise.b;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="_Orders")
public class Order {

	public Order() {
		super();
	}
	@Id
	@GeneratedValue
	private int id;
	
	public Order(int orderid, Date date, Customer customer, List<OrderLine> orderLines) {
		super();
		this.orderid = orderid;
		this.date = date;
		this.customer = customer;
		this.orderLines = orderLines;
	}
	private int orderid;
	private Date date;
	
	
	@ManyToOne
	@JoinColumn(name="customer_id")
	private Customer customer;
	
	
	@OneToMany(cascade={CascadeType.PERSIST})
	@JoinColumn(name="order_id")
	private List<OrderLine> orderLines=new ArrayList<>();
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	
	@Column
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", orderid=" + orderid + ", date=" + date + ", customer=" + customer
				+ ", orderLines=" + orderLines + "]";
	}
}
