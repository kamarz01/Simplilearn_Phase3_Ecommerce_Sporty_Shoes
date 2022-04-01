package com.sportyshoes.ecommerce.repository;

import com.sportyshoes.ecommerce.dto.Order;
import com.sportyshoes.ecommerce.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Orders,Integer> {
    public List<Orders> findAllByDateEquals(LocalDate date);
}
