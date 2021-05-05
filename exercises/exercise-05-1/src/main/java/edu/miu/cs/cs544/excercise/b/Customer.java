package edu.miu.cs.cs544.excercise.b;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Customers")
public class Customer {
	
	@Id
	@GeneratedValue
	private int id;
	
	private String firstname;
	public Customer() {
		super();
	}
	private String lastname;
	
	@OneToMany(mappedBy="customer")
	private List<Order> order;
	
	public int getId() {
		return id;
	}
	public Customer(String firstname, String lastname, List<Order> order) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.order = order;
	}
	public Customer(String firstname, String lastname) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	@Column
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + "]";
	}
	

}
