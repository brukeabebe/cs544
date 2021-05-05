package edu.miu.cs.cs544.excercise.b;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="CDs")
public class CD extends Product {

	
	

	private String artist;
	
	public CD(String name, String description, String artist) {
		super(name, description);
		this.artist= artist;
	}
	
	public CD() {
	
	}

	public CD(String artist) {
		super();
		this.artist = artist;
	}

	@Override
	public String toString() {
		return "CD [artist=" + artist + "]";
	}

	@Column
	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}
	
	
	
}
