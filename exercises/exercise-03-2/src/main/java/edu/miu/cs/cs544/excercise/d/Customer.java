package edu.miu.cs.cs544.excercise.d;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="Customers")
public class Customer {

	@Id
	@GeneratedValue
	private int  id;
	
	
	
	private String name;
	
	@OneToMany(cascade=CascadeType.PERSIST)
	@JoinColumn(name="customer_id")

	List<Reservation> reservations  =new ArrayList<>();

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", reservations=" + reservations + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Reservation> getReservation() {
		return reservations;
	}

	public void setReservation(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	
	public void addReservation(Reservation reservation)
	{
		this.reservations.add(reservation);
	}
	
	public Customer()
	{
		
	}
	public Customer(String name, List<Reservation> reservations) {
		super();
		this.name = name;
		this.reservations=reservations;
	};
	
	
	

	
}
