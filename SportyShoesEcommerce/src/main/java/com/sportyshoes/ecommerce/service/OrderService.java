package com.sportyshoes.ecommerce.service;

import com.sportyshoes.ecommerce.dto.Order;
import com.sportyshoes.ecommerce.entity.Orders;
import com.sportyshoes.ecommerce.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repo;
    @Autowired
    private UserService userService;

    public Orders AddNewOrder(Order order){
        Orders o = new Orders();
        o.setFirstName(order.getFirstName());
        o.setLastName(order.getLastName());
        o.setEmail(order.getEmail());
        o.setAddress(order.getAddress());
        o.setTotalPrice(order.getTotalPrice());
        o.setProducts(order.getProducts());
        o.setUser(userService.getUserById(order.getUserId()));
        return repo.save(o);
    }

    public List<Orders> getAllOrders(){
        return repo.findAll();
    }

    public List<Orders> getOrdersByDate(LocalDate date){
        return repo.findAllByDateEquals(date);
    }
}
