package com.urbanBites.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.urbanBites.Model.DrinkProduct;
import com.urbanBites.Repository.DrinkProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DrinkProductService {
	
	    @Autowired
	    private DrinkProductRepository drinkRepository;

	    public List<DrinkProduct> getAllProducts() {
	        return (List<DrinkProduct>) drinkRepository.findAll();
	    }

	    public ResponseEntity<DrinkProduct> getProductById(long id) {
	        Optional<DrinkProduct> productOptional = drinkRepository.findById(id);
	        return productOptional.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	    }

	    public ResponseEntity<DrinkProduct> addProduct(DrinkProduct drink) {
	        DrinkProduct savedProduct = drinkRepository.save(drink);
	        return ResponseEntity.ok(savedProduct);
	    }
}
