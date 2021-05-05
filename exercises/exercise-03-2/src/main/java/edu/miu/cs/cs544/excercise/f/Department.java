package edu.miu.cs.cs544.excercise.f;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="Departments")
public class Department {

	@Id
	@GeneratedValue
	private int  id;
	private String name;
	
	
	@OneToMany(mappedBy="department")
	private List<Employee> employees;
	
	public Department()
	{
		
	}

	public Department(String name) {
		super();
	
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public void  addEmployee(Employee employee)
	{
		this.employees.add(employee);
	}
	public Department(String name, List<Employee> employees) {
		super();
		this.name = name;
		this.employees = employees;
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
		return "Department [id=" + id + ", name=" + name +"]";
	}
}
