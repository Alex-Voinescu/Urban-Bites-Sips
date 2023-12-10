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
	        DrinkProduct drink1 = new DrinkProduct("Produs 1","Descriere produs 1", "330ml", 25);
	        DrinkProduct drink2 = new DrinkProduct("Produs 2","Descriere produs 2", "500ml", 13);
	        DrinkProduct drink3 = new DrinkProduct("Produs 3","Descriere produs 3", "800ml", 20);
	        drinkProductRepository.save(drink1);
	        drinkProductRepository.save(drink2);
	        drinkProductRepository.save(drink3);
	    }	
}


