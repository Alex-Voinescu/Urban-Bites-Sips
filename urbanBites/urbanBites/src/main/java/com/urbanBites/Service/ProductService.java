package com.urbanBites.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.urbanBites.urbanBites.Product;
import com.urbanBites.urbanBites.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return (List<Product>) productRepository.findAll();
    }

    public ResponseEntity<Product> getProductById(Long productId) {
        Optional<Product> productOptional = productRepository.findById(productId);
        return productOptional.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<Product> addProduct(Product product) {
        Product savedProduct = productRepository.save(product);
        return ResponseEntity.ok(savedProduct);
    }
}