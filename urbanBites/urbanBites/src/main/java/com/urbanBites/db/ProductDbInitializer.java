package com.urbanBites.db;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import com.urbanBites.Model.Product;
import com.urbanBites.Repository.ProductRepository;

@Service
public class ProductDbInitializer implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
        Product product = new Product("Produs 1","Descriere produs 1", "250g", 25);
        

        productRepository.save(product);
    }
}
