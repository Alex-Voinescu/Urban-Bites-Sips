
package com.urbanBites.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.urbanBites.Model.Order;
import com.urbanBites.Model.Product;
import com.urbanBites.Repository.OrderRepository;
import com.urbanBites.Service.OrderService;
import com.urbanBites.Service.ProductService;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;
    
    @Autowired
    private ProductService productService;
    
    @Autowired
    private OrderRepository orderRepository;



    @GetMapping
    public String showOrderList(Model model) {
    	model.addAttribute("orders", orderRepository.findAll());
        return "order-list";
    }
    
    @GetMapping("/place")
    public String showOrderForm(Model model) {
    	Order order= new Order();
        model.addAttribute(order);
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "order-form";
    }
    
    @GetMapping("/order-details")
    public String showOrderDetails(Model model) {
       
         List<Order> orders = orderRepository.findAll();
    
         model.addAttribute("orders", orders);
        Order order = new Order(1, LocalDate.now(),20.0, Arrays.asList(
                new Product("Product 1", "Descriere produs 1","250g",10.0),
                new Product("Product 2","Descriere produs 2","330ml",10.0 )
        ));
        model.addAttribute("orders", Collections.singletonList(order));

        
        return "order";
    }
    

    
    @PostMapping("/place")
    public String placeOrder(@RequestParam("totalAmount") double totalAmount, Order order) {
        order.setDate(LocalDate.now());
        order.setTotalAmount(totalAmount);
      
        orderRepository.save(order);
        return "redirect:/orders";
    }


    

}

