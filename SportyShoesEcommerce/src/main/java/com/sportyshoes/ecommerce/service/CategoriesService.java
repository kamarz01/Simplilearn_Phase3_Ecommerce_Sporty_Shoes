package com.sportyshoes.ecommerce.service;

import com.sportyshoes.ecommerce.entity.Categories;
import com.sportyshoes.ecommerce.entity.Products;
import com.sportyshoes.ecommerce.repository.CategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
public class CategoriesService {

    @Autowired
    private CategoriesRepository repo;

    public List<Categories> getAllCategories(){
        return repo.findAll();
    }

    public Categories getCategoryById(int id){
        return repo.findById(id).get();
    }

    public Categories addNewCategory(String name){
        Categories _cat = new Categories(name);
        return repo.save(_cat);
    }

    public List<Products> getProductsForCategory(int id){
        return repo.findById(id).get().getProducts();
    }

    public boolean deleteCategoryById(int id){
        try {
            repo.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
