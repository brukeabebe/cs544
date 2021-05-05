package edu.miu.cs.cs544.excercise.f;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Employees")
public class Employee {

	
	@Id
	@GeneratedValue
	private int id;
	
	private int employeenumber;
	private String name;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	 @JoinColumn(name="department_id")
	private  Department department;
	
	

	@ManyToOne(cascade=CascadeType.PERSIST)
	 @JoinColumn(name="office_id")
	private Office office;
	
	
	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public Department getDepartment() {
		return department;
	}



	public void setDepartment(Department department) {
		this.department = department;
	}



	public Office getOffice() {
		return office;
	}



	public void setOffice(Office office) {
		this.office = office;
	}



	public Employee(int employeenumber, String name, Department department, Office office) {
		super();
		this.employeenumber = employeenumber;
		this.name = name;
		this.department=department;
		this.office=office;
	}
	
	
	
	public Employee() {
		
	}



	@Column
	public int getEmployeenumber() {
		return employeenumber;
	}



	public void setEmployeenumber(int employeenumber) {
		this.employeenumber = employeenumber;
	}



	
	@Column
	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	@Override
	public String toString() {
		return "Employee [id=" + id + ", employeenumber=" + employeenumber + ", name=" + name + ", department="
				+ department + ", office=" + office + "]";
	}
	
	
	
	
}
