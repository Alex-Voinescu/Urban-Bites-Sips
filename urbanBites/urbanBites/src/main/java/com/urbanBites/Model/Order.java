package com.urbanBites.Model;

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
	private Long id;
	
	 @OneToMany
    private List<Product> products;
	 
    private double totalAmount;
    private String status;
  
    public Order() {}

    public Order(List<Product> products) {
        this.products = products;
        this.products = products;
        calculateTotalAmount();
    }
   
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "Order [id=" + id + ", products=" + products + ", totalAmount=" + totalAmount + ", status=" + status
				+ "]";
	}

	private void calculateTotalAmount() {
        this.totalAmount = 0.0;
        for (Product product : products) {
            this.totalAmount += product.getPrice();
        }
    }
}