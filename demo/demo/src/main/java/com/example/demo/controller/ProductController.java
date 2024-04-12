package com.example.demo.controller;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;
import java.util.Optional;

@Controller
@RequestMapping("/")
public class ProductController {


    private final ProductRepository repository;

    public ProductController(ProductRepository repository){
        this.repository = repository;
    }

    @GetMapping
    public String findAll(Model model){
        model.addAttribute("products",this.repository.findAll());
        return "products-list";
    }

    @RequestMapping("/product/{id}")
    public String productView(@PathVariable Long id, Model model) {
        model.addAttribute("product", this.repository.findAllById(Collections.singleton(id)));
        return "product-view";
    }

    @RequestMapping("/product/edit/{id}")
    public String productEdit(@PathVariable Long id, Model model) {
        model.addAttribute("product", this.repository.findById(id));
        return "product-edit";
    }
}
