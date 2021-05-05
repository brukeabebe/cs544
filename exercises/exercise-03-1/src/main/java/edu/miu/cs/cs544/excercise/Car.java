package edu.miu.cs.cs544.excercise;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="Cars")
public class Car {
	
	
	@Id
	@GeneratedValue
	private int id;
	private String brand;
	private Date year;
	private double price;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="owner_id")
	private Owner owner;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	@Column
	public Date getYear() {
		return year;
	}
	public void setYear(Date year) {
		this.year = year;
	}
	
	@Column
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public Car()
	{
		
	}
	public Car(String brand, Date year, double price, Owner owner) {
		super();
		
		this.brand = brand;
		this.year = year;
		this.price = price;
		this.owner= owner;
	}
	@Override
	public String toString() {
		return "Car [id=" + id + ", brand=" + brand + ", year=" + year + ", price=" + price + ", owner=" + owner + "]";
	}

}
