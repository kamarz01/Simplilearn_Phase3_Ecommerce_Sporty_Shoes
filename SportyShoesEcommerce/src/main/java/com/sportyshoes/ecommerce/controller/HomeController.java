package com.sportyshoes.ecommerce.controller;

import com.sportyshoes.ecommerce.service.CategoriesService;
import com.sportyshoes.ecommerce.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {
    @Autowired
    private CategoriesService categoriesService;
    @Autowired
    private ProductsService productsService;

    @RequestMapping("/")
    public String home(Model model, HttpSession session){
        model.addAttribute("cats",categoriesService.getAllCategories());
        model.addAttribute("products",productsService.getAllProducts());
        return "index";
    }
}
