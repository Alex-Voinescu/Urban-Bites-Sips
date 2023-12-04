package com.urbanBites.Controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.urbanBites.Model.DrinkProduct;
import com.urbanBites.Model.Product;
import com.urbanBites.Repository.DrinkProductRepository;
import com.urbanBites.Repository.ProductRepository;
import com.urbanBites.Service.DrinkProductService;
import com.urbanBites.Service.ProductService;


@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;
    

    @Autowired
    private DrinkProductService drinkService;
    
    @Autowired
    private ProductRepository productRepository;
    
    @Autowired
    private DrinkProductRepository drinkRepository;

    @GetMapping
    public String showAllProducts(Model model) {
        model.addAttribute("products", productRepository.findAll());
        model.addAttribute("drinks", drinkRepository.findAll());
        return "products";
    }

    @GetMapping("/addFood")
    public String showAddFoodForm(Model model) {
        Product product = new Product();
        model.addAttribute(product);
        return "addFood";
    }
    @GetMapping("/addDrink")
    public String showAddSipsForm(Model model) {
        DrinkProduct drink = new DrinkProduct();
        model.addAttribute(drink);
        return "addDrink";
    }

    @PostMapping("/addFood")
    public String saveFood(@ModelAttribute Product product) {
        productRepository.save(product);
        return "redirect:/products";
    }
    @PostMapping("/addDrink")
    public String saveDrink(@ModelAttribute DrinkProduct drink) {
    	drinkRepository.save(drink);
        return "redirect:/products";
    }
    @GetMapping("/search")
    public String searchProducts(@RequestParam Integer id, Model model) {
        model.addAttribute("products", productService.getProductById(id));
        return "products";
    }
}
