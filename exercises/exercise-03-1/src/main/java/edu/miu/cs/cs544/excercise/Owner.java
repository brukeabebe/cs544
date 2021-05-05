package edu.miu.cs.cs544.excercise;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Owners")
public class Owner {

	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String address;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public Owner()
	{
		
	}
	public Owner(String name, String address) {
		super();
	
		this.name = name;
		this.address = address;
	}
	@Override
	public String toString() {
		return "Owner [id=" + id + ", name=" + name + ", address=" + address + "]";
	}
	
	
	
	
	
}
