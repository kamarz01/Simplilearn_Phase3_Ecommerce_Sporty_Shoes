package com.sportyshoes.ecommerce.controller;

import com.sportyshoes.ecommerce.entity.Products;
import com.sportyshoes.ecommerce.service.ProductsService;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private ProductsService productsService;

    @GetMapping
    public String ShowCartAndCheckout(HttpSession session, Model model){
        if (session.getAttribute("user") == null)
            return "redirect:/user/login";

        List<Integer> list = new ArrayList<>();
        if (session.getAttribute("cart") != null) {
            list = (List<Integer>) session.getAttribute("cart");
        }
        List<Products> products = productsService.getProductListByIds(list);
        model.addAttribute("products",products);
        model.addAttribute("totalPrice",products.stream().mapToInt(o -> Math.toIntExact(o.getPrice())).sum());
        return "cart";
    }

    @GetMapping("add")
    public String AddToCart(@RequestParam("productId") String id, HttpSession session){
        if (session.getAttribute("user") == null)
            return "redirect:/user/login";

        List<Integer> listOfProducts = new ArrayList<>();
        if (session.getAttribute("cart") != null) {
            listOfProducts = (List<Integer>) session.getAttribute("cart");
        }
        listOfProducts.add(Integer.parseInt(id));
        session.setAttribute("cart", listOfProducts);
        session.setAttribute("cartCount",((int) session.getAttribute("cartCount")) + 1);
        return "redirect:/";
    }

    @GetMapping("/clear")
    public String ClearCart(HttpSession session){
        session.setAttribute("cart", new ArrayList<>());
        session.setAttribute("cartCount",0);
        return "redirect:/";
    }

}
