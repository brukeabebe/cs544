package edu.miu.cs.cs544.excercise.f;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="Offices")
public class Office {

	
	

	@Id
	@GeneratedValue
	public int id;
	
	private int roonumber;
	private String building;
	
	
	@OneToMany(mappedBy="office")
	private List<Employee> employee= new ArrayList<>();

	public Office(int roonumber, String building, List<edu.miu.cs.cs544.excercise.f.Employee> employee) {
		super();
		this.roonumber = roonumber;
		this.building = building;
		employee = employee;
	}

	
	public Office()
	{
		
	}
	@Override
	public String toString() {
		return "Office [id=" + id + ", roonumber=" + roonumber + ", building=" + building + ", employee=" + employee
				+ "]";
	}


	public Office(int roonumber, String building) {
		super();
		this.roonumber = roonumber;
		this.building = building;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRoonumber() {
		return roonumber;
	}

	public void setRoonumber(int roonumber) {
		this.roonumber = roonumber;
	}

	public String getBuilding() {
		return building;
	}

	public void setBuilding(String building) {
		this.building = building;
	}

	public List<Employee> getEmployee() {
		return employee;
	}

	public void setEmployee(List<Employee> employee) {
		employee = employee;
	}

	
	
	
}
