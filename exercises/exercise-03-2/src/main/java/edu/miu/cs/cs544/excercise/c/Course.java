package edu.miu.cs.cs544.excercise.c;

import java.util.ArrayList;
import java.util.List;

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
@Table(name="Courses")
public class Course {

	@Id
	@GeneratedValue
	private int  id;
	
	
	private String courseNumber;
	private String name;
	
	@ManyToMany(mappedBy="courses")
	List<Student> students =new ArrayList<>();;
	
	public Course()
	{
		
	}

	

	@Column
	public String getCourseNumber() {
		return courseNumber;
	}



	public void setCourseNumber(String courseNumber) {
		this.courseNumber = courseNumber;
	}


	
	public List<Student> getStudent() {
		return  this.students;
	}



	public void setStudent(List<Student> students) {
		this.students = students;
	}



	@Override
	public String toString() {
		return "Course [id=" + id + ", courseNumber=" + courseNumber + ", name=" + name + "]";
	}



	public Course(String courseNumber, String name) {
		super();
		this.courseNumber = courseNumber;
		this.name = name;
		
	}

	
	public void addStudent(Student student)
	{
		this.students.add(student);
	}
	
			


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

	
}
