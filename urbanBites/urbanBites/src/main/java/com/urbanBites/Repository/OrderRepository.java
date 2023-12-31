package com.urbanBites.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.urbanBites.Model.Order;
import com.urbanBites.Model.Product;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
	Optional<Order> findById(Integer id);
}
