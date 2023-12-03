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
        Product product = new Product();
        product.setName("Produs 1");
        product.setDescription("Descriere produs 1");
        product.setPrice(20.0);

        productRepository.save(product);
    }
}
