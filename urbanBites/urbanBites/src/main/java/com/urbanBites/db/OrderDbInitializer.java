package com.urbanBites.db;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.urbanBites.Model.Order;
import com.urbanBites.Model.Product;
import com.urbanBites.Repository.OrderRepository;
import com.urbanBites.Repository.ProductOrderRepository;
import com.urbanBites.Repository.ProductRepository;

@Component
public class OrderDbInitializer implements CommandLineRunner {
	 
	@Autowired
	    private OrderRepository orderRepository;
	
	@Autowired
	    private ProductOrderRepository productOrderRepository;
	  
	    @Override
	    public void run(String... args) throws Exception {
	    	Product product1 = new Product("Product 1", "Descriere produs 1", "250g", 10.0);
	        Product product2 = new Product("Product 2", "Descriere produs 2", "330ml", 15.0);
	        
	        productOrderRepository.save(product1);
	        productOrderRepository.save(product2);
	    	
	        Order order = new Order(1, LocalDate.now(), 20.0, Arrays.asList(product1, product2));

	        order.calculateTotalAmount(); 
	        orderRepository.save(order);
}
}