package com.sportyshoes.ecommerce.controller;

import com.sportyshoes.ecommerce.dto.Order;
import com.sportyshoes.ecommerce.entity.Products;
import com.sportyshoes.ecommerce.service.OrderService;
import com.sportyshoes.ecommerce.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private ProductsService productsService;

    @RequestMapping("create")
    public String CreateOrder(Order order, HttpSession session){
        List<Integer> list = (List<Integer>) session.getAttribute("cart");
        List<Products> products = productsService.getProductListByIds(list);
        order.setTotalPrice(String.valueOf(products.stream().mapToInt(o -> Math.toIntExact(o.getPrice())).sum()));
        order.setProducts(list.toString());
        order.setUserId((Integer) session.getAttribute("userId"));
        orderService.AddNewOrder(order);
        session.setAttribute("cart", new ArrayList<>());
        session.setAttribute("cartCount",0);
        return "order-ok";
    }
}
