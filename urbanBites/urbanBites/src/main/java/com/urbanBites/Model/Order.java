package com.urbanBites.Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "\"order\"")
public class Order {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private LocalDate date;
	private double totalAmount;
	
	 @OneToMany
    private List<Product> products;
	 
    
 
  
    public Order() {}
    

    public Order(Integer id, LocalDate date, double totalAmount, List<Product> products) {
		super();
		this.id = id;
		this.date = date;
		this.totalAmount =totalAmount;
		this.products = products;
		if (this.products == null) {
            this.products = new ArrayList<>();
        }

	}

    public Integer getId() {
		return id;
	}




	public LocalDate getDate() {
		return date;
	}


	public void setDate(LocalDate date) {
		this.date = date;
	}


	public void setId(Integer id) {
		this.id = id;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	

	@Override
	public String toString() {
		return "Order [id=" + id + ", date=" + date + ", totalAmount="
				+ totalAmount + ", products=" + products + "]";
	}


	public void calculateTotalAmount() {
	    if (this.products != null) {
            this.totalAmount = this.products.stream()
                    .mapToDouble(Product::getPrice)
                    .sum();
        } else {
            this.totalAmount = 0.0;
        }
	    }
}
