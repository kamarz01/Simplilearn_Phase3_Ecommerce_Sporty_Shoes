package com.sportyshoes.ecommerce.controller;

import com.sportyshoes.ecommerce.dto.User;
import com.sportyshoes.ecommerce.entity.Users;
import com.sportyshoes.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Objects;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String Login(){
        return "customer-login";
    }

    @GetMapping("/signup")
    public String Signup(){
        return "customer-signup";
    }

    @PostMapping("/login")
    public String Login(User user, Model model, HttpSession session){
        Users u = userService.validateUserLogin(user,"customer");
        if (!Objects.isNull(user) && !Objects.isNull(u)){
            session.setAttribute("user",u.getUsername());
            session.setAttribute("userId",u.getId());
            session.setAttribute("cartCount",0);
            return "redirect:/";
        }
        model.addAttribute("error","Wrong username/password");
        return "customer-login";
    }

    @PostMapping("/signup")
    public String Signup(User user, HttpSession session){
        userService.addNewUser(user);
        session.setAttribute("user",user.getUsername());
        return "redirect:/";
    }

    @GetMapping("/logout")
    public String Logout(HttpSession session){
        session.setAttribute("user",null);
        session.setAttribute("cartCount",null);
        session.setAttribute("userId",null);
        session.invalidate();
        return "redirect:/";
    }
}
