package com.urbanBites.Repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.urbanBites.Model.DrinkProduct;

@Repository
public interface DrinkProductRepository extends JpaRepository<DrinkProduct, Long> {
	  List<DrinkProduct> findByName(String name);
}

