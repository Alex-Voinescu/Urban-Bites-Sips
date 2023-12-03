package com.urbanBites.db;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import com.urbanBites.Model.DrinkProduct;
import com.urbanBites.Repository.DrinkProductRepository;


@Service
public class DrinkDbInitializer implements CommandLineRunner {
	
	    @Autowired
	    private DrinkProductRepository drinkProductRepository;

	    @Override
	    public void run(String... args) throws Exception {
	        DrinkProduct drink = new DrinkProduct("Produs 1","Descriere produs 1", "330ml", 25);
	        
	        drinkProductRepository.save(drink);
	    }	
}


