package com.sportyshoes.ecommerce.controller;

import com.sportyshoes.ecommerce.dto.Product;
import com.sportyshoes.ecommerce.dto.User;
import com.sportyshoes.ecommerce.entity.Users;
import com.sportyshoes.ecommerce.service.CategoriesService;
import com.sportyshoes.ecommerce.service.ProductsService;
import com.sportyshoes.ecommerce.service.UserService;
import com.sportyshoes.ecommerce.utils.Constant;
import com.sportyshoes.ecommerce.utils.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Random;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;
    @Autowired
    private CategoriesService categoriesService;
    @Autowired
    private ProductsService productsService;

    @GetMapping
    public String Home(Model model){
        model.addAttribute("view", "home");
        return "admin-home";
    }

    @PostMapping("/login")
    public String Login(User user, Model model, HttpSession session){
        Users u = userService.validateUserLogin(user,"admin");
        if (!Objects.isNull(user) && !Objects.isNull(u)){
            session.setAttribute("admin",u.getUsername());
            session.setAttribute("adminId",u.getId());
            model.addAttribute("view", "home");
            return "admin-home";
        }
        model.addAttribute("error","Wrong username/password");
        return "admin-login";
    }

    @GetMapping("/users")
    public String Users(Model model){
        model.addAttribute("view", "users");
        model.addAttribute("userList",userService.getAllUsersByType("customer"));
        return "admin-home";
    }

    @GetMapping("/user")
    public String UserAction(@RequestParam(value = "id", required = false) String id,
                             @RequestParam(value = "search", required = false) String search,
                             @RequestParam(value = "action", required = true) String action,
                             Model model){
        if (action.equals("search")){
            List<Users> users = userService.searchUsers(search,"customer");
            model.addAttribute("userList",users);
            model.addAttribute("view", "userSearch");
            return "admin-home";
        }else if (action.equals("delete")){
            userService.deleteUserById(Integer.parseInt(id));
            return "redirect:/admin/users";
        }
        return "redirect:/admin/users";
    }

    @GetMapping("/categories")
    public String Categories(Model model){
        model.addAttribute("view", "categories");
        model.addAttribute("catList",categoriesService.getAllCategories());
        return "admin-home";
    }

    @GetMapping("/category")
    public String CategoryAction(@RequestParam(value = "id", required = true) String id,
                                       @RequestParam(value = "action", required = true) String action,
                                       Model model){
        if (action.equals("delete")) {
            if (!categoriesService.deleteCategoryById(Integer.parseInt(id))) {
                model.addAttribute("error","Category can't be deleted as it has related products assigned.");
            }
            return "redirect:/admin/categories";
        }
        return "redirect:/admin/categories";
    }

    @PostMapping("/category")
    public String AddCategory(@RequestParam(value = "name", required = true) String name, Model model){
            categoriesService.addNewCategory(name);
            return "redirect:/admin/categories";
    }

    @GetMapping("/products")
    public String Products(Model model){
        model.addAttribute("view", "products");
        model.addAttribute("catList", categoriesService.getAllCategories());
        model.addAttribute("prodList",productsService.getAllProducts());
        return "admin-home";
    }

    @PostMapping("/product")
    public String AddProduct(Product product, Model model,@RequestParam("imagePath") MultipartFile image) throws IOException {
        String fileName = new Random().nextInt(99999) + StringUtils.cleanPath(image.getOriginalFilename());
        product.setImage(fileName);
        productsService.addNewProduct(product);
        FileUploadUtil.saveFile( fileName, image);
        return "redirect:/admin/products";
    }

    @GetMapping("/product/delete")
    public String DeleteProduct(@RequestParam("id") String id){
        productsService.deleteProductById(Integer.parseInt(id));
        return "redirect:/admin/products";
    }

    @PostMapping("/changepassword")
    public String ChangePassword(String password,HttpSession session){
        int id = Integer.parseInt(session.getAttribute("adminId").toString());
        userService.changeAdminPassword(id,password);
        return "redirect:/admin/logout";
    }

    @GetMapping("/changepassword")
    public String ChangePassword(){
        return "admin-password";
    }

    @GetMapping("/logout")
    public String Logout(HttpSession session){
        session.setAttribute("admin",null);
        session.invalidate();
        return "admin-login";
    }
}
