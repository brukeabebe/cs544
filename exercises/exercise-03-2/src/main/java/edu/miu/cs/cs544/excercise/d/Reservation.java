package edu.miu.cs.cs544.excercise.d;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Reservations")
public class Reservation {

	
	@Id
	@GeneratedValue
	public int id;
	
	public Date date;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	@Column
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	public Reservation()
	{
		
	}

	@Override
	public String toString() {
		return "Reservation [id=" + id + ", date=" + date + "]";
	}

	public Reservation(Date date) {
		super();
		this.date = date;
	}
	
	
	




	


	
	
	
	
	
}
