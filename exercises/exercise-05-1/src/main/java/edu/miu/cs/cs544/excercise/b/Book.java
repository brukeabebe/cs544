package edu.miu.cs.cs544.excercise.b;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="Books")
public class Book extends Product  {



	
	private String title;
	
	public Book() {
	
		
	}

	
	public Book(String name, String description, String Title) {
		super(name, description);
		this.title=Title;
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public String toString() {
		return "Book [title=" + title + "]";
	}

	
	@Column
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	
}
