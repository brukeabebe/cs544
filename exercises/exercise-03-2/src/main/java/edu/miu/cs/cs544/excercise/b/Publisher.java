package edu.miu.cs.cs544.excercise.b;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Publishers")
public class Publisher {

	
	@Id
	@GeneratedValue
	public int id;
	
	
	public String name;
	
	
	
	public Publisher(String name) {
		super();
		
		this.name = name;
	}
	
	
	
	public Publisher() {
		
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
		return "Publisher [id=" + id + ",name=" + name + "]";
	}
	
	
	
	
}
