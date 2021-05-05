package edu.miu.cs.cs544.excercise.b;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="Books")
public class Book {

	@Id
	@GeneratedValue
	private int  id;
	private String isbn;
	private String title;
	private String author;
	
	
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	
	@JoinTable(name="publisher_book",
	joinColumns= { @JoinColumn(name="publisher_id")},
	inverseJoinColumns = { @JoinColumn(name = "book_id") })
	

	private Publisher publisher;
	
	public Book()
	{
		
	}

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public void  setPublisher(Publisher publisher)
	{
		this.publisher=publisher;
	}
	
	public Book(String isbn, String title, String author) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.author = author;
	}
	
	
	public Book(String isbn, String title, String author, Publisher publisher ){
		super();
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		
		this.publisher= publisher;
	}


   @Column
	public String getIsbn() {
		return isbn;
	}



	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}



	
	@Column
	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}


	@Column
	public String getAuthor() {
		return author;
	}



	public Publisher getPublisher() {
		return publisher;
	}



	public void setAuthor(String author) {
		this.author = author;
	}



	@Override
	public String toString() {
		return "Book [id=" + id + ", isbn=" + isbn + ", title=" + title + ", author=" + author + ", publisher="
				+ publisher + "]";
	}



	



	



	
}
