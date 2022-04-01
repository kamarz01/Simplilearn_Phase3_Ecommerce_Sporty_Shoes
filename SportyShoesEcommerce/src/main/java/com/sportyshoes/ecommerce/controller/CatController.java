package com.sportyshoes.ecommerce.controller;

import com.sportyshoes.ecommerce.service.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/category")
public class CatController {

    @Autowired
    private CategoriesService categoriesService;

    @RequestMapping("/{id}")
    public String GetProductsForCategory(@PathVariable String id, Model model){
        model.addAttribute("cats",categoriesService.getAllCategories());
        model.addAttribute("products",categoriesService.getProductsForCategory(Integer.parseInt(id)));
        return "category";
    }
}
