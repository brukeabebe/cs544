package edu.miu.cs.cs544.excercise.c;

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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Students")
public class Student {

	
	@Id
	@GeneratedValue
	public int id;
	
	public String studentId;
	public String firstName;
	public String lastName;
	
	@ManyToMany(cascade=CascadeType.PERSIST)
	@JoinTable(name = "Student_Course", 
	 joinColumns = { @JoinColumn(name = "Student_id") }, 
	 inverseJoinColumns = { @JoinColumn(name = "Course_id")})
	public List<Course> courses= new ArrayList<>();
	
	
public Student() {
	
}


	public Student(String studentId, String firstName, String lastName) {
	super();
	this.studentId = studentId;
	this.firstName = firstName;
	this.lastName = lastName;
	}


	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	
	@Column
	public String getStudentId() {
		return studentId;
	}



	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}



	
	@Column
	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	
	@Column
	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	

	public List<Course> getCourses() {
		return courses;
	}



	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}



	public void addCourse(Course course)
	{
		this.courses.add(course);
	}
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", studentId=" + studentId + ", firstName=" + firstName + ", lastName=" + lastName
				+ "]";
	}



	


	
	
	
	
	
}
