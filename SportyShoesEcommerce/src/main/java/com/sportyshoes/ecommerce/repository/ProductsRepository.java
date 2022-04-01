package com.sportyshoes.ecommerce.repository;

import com.sportyshoes.ecommerce.entity.Categories;
import com.sportyshoes.ecommerce.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductsRepository extends JpaRepository<Products,Integer> {
}
