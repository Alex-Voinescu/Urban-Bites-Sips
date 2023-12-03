
package com.urbanBites.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.urbanBites.Service.OrderService;
import com.urbanBites.urbanBites.Order;
import com.urbanBites.urbanBites.OrderRepository;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;
    
    @Autowired
    private OrderRepository orderRepository;

    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long orderId) {
        return orderService.getOrderById(orderId);
    }

    @PostMapping
    public ResponseEntity<Order> placeOrder(@RequestBody Order order) {
        return orderService.placeOrder(order);
    }

}

