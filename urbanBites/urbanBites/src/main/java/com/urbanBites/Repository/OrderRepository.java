package com.urbanBites.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.urbanBites.Model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    
}
