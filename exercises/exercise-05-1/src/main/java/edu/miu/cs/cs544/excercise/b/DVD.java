package edu.miu.cs.cs544.excercise.b;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="DVDs")
public class DVD extends Product {

	
	
	
	private String genere;

	public DVD(String name, String description, String genere) {
		super(name, description);
		this.genere = genere;
	}
	@Column
	public String getGenere() {
		return genere;
	}

	public DVD() {
		
	}

	public DVD(String genere) {
		super();
		this.genere = genere;
	}

	@Override
	public String toString() {
		return "DVD [genere=" + genere + "]";
	}
	public void setGenere(String genere) {
		this.genere = genere;
	}
}
