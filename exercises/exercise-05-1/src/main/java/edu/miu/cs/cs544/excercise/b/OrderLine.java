package edu.miu.cs.cs544.excercise.b;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="OrderLines")
public class OrderLine {
    
	
	public OrderLine() {
		super();
	}

	@Id
	@GeneratedValue
	private int id;
	
	
	
	private int quantity;
	
	
	@ManyToOne
	@JoinColumn(name="product_id")
	private Product product;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	@Column
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public OrderLine(int quantity, Product product) {
		super();
		this.quantity = quantity;
		this.product = product;
	}

	@Override
	public String toString() {
		return "OrderLine [id=" + id + ", quantity=" + quantity + ", product=" + product + "]";
	}

	public OrderLine(int quantity) {
		super();
		this.quantity = quantity;
	}
	
	
	
}
