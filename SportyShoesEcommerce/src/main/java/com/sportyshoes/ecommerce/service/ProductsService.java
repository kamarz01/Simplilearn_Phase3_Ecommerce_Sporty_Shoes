package com.sportyshoes.ecommerce.service;

import com.sportyshoes.ecommerce.dto.Product;
import com.sportyshoes.ecommerce.entity.Categories;
import com.sportyshoes.ecommerce.entity.Products;
import com.sportyshoes.ecommerce.repository.CategoriesRepository;
import com.sportyshoes.ecommerce.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class ProductsService {

    @Autowired
    private ProductsRepository repo;
    @Autowired
    private CategoriesRepository catRepo;

    public List<Products> getAllProducts(){
        return repo.findAll();
    }

    public Products addNewProduct(Product product){
        Products _product = new Products(product.getName(),product.getDesc(),product.getPrice(),product.getImage());
        _product.setCategories(catRepo.getById(product.getCatId()));
        return repo.save(_product);
    }

    public List<Products> getProductListByIds(List<Integer> ids){
        List<Products> _prods = new ArrayList<>();
        for (int id:ids) {
            Products p = repo.getById(id);
            if (!Objects.isNull(p))
                _prods.add(p);
        }
        return _prods;
    }

    public boolean deleteProductById(int id){
        try {
            repo.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
