package com.sportyshoes.ecommerce.repository;

import com.sportyshoes.ecommerce.entity.Categories;
import com.sportyshoes.ecommerce.entity.Products;
import com.sportyshoes.ecommerce.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriesRepository extends JpaRepository<Categories,Integer> {
}
