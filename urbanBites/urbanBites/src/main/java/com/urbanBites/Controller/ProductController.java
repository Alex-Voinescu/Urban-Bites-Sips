package com.urbanBites.Controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.urbanBites.Model.Product;
import com.urbanBites.Repository.ProductRepository;
import com.urbanBites.Service.ProductService;


@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;
    
    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public String showAllProducts(Model model) {
        model.addAttribute("products", productRepository.findAll());
        return "products";
    }

    @GetMapping("/addProduct")
    public String showAddProductForm(Model model) {
        Product product = new Product();
        product.setName("ciorba");
        product.setDescription("e buna");
        product.setPrice(25);
        product.setId(1);
        model.addAttribute(product);
        return "addProduct";
    }

    @PostMapping("/addProduct")
    public String saveProduct(@ModelAttribute Product product) {
        productRepository.save(product);
        return "redirect:/products";
    }
    @GetMapping("/search")
    public String searchProducts(@RequestParam Integer id, Model model) {
        model.addAttribute("products", productService.getProductById(id));
        return "products";
    }
}
