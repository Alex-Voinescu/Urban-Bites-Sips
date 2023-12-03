package com.urbanBites.Repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.urbanBites.Model.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	  List<Product> findByName(String name);
}