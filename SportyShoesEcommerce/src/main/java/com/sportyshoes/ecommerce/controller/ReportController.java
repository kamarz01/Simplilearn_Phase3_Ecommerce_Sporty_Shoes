package com.sportyshoes.ecommerce.controller;

import com.sportyshoes.ecommerce.dto.Order;
import com.sportyshoes.ecommerce.dto.Report;
import com.sportyshoes.ecommerce.entity.Orders;
import com.sportyshoes.ecommerce.entity.Products;
import com.sportyshoes.ecommerce.service.CategoriesService;
import com.sportyshoes.ecommerce.service.OrderService;
import com.sportyshoes.ecommerce.service.ProductsService;
import com.sportyshoes.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/admin")
public class ReportController {

    @Autowired
    private CategoriesService categoriesService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private ProductsService productsService;
    @Autowired
    private UserService userService;

    @RequestMapping("report")
    public String ShowPurchasingReport(Model model){
        model.addAttribute("view", "report");
        model.addAttribute("catList", categoriesService.getAllCategories());
        List<Orders> orders = orderService.getAllOrders();
        List<Report> report = getReportFromOrders(orders);
        model.addAttribute("reportList",report);
        return "admin-home";
    }

    @PostMapping("report/filter")
    public String FilterReport(@RequestParam("date") String date,@RequestParam("catId") String catId, Model model){
        model.addAttribute("view", "report-filter");
        LocalDate d = LocalDate.parse(date);
        List<Orders> orders = orderService.getOrdersByDate(d);
        List<Report> report = getReportFromOrders(orders);
        List<Report> result = new ArrayList<>();
        for (Report rep:report) {
            for (Products prd: rep.getProducts()) {
                if (prd.getCategories().getId() == Integer.parseInt(catId))
                    result.add(rep);
            }
        }
        model.addAttribute("result",result);
        return "admin-home";
    }

    public List<Report> getReportFromOrders(List<Orders>  orders){
        List<Report> report = new ArrayList<>();
        for (Orders o:orders) {
            Report r = new Report();
            r.setId(o.getId());
            r.setTotalPrice(o.getTotalPrice());
            r.setAddress(o.getAddress());
            r.setFirstName(o.getFirstName());
            r.setLastName(o.getLastName());
            r.setEmail(o.getEmail());
            int[] numbers = Arrays.stream(o.getProducts()
                    .replace("[","")
                    .replace("]","")
                    .replace(" ","")
                    .split(",")).mapToInt(Integer::parseInt).toArray();
            List<Integer> list = Arrays.stream(numbers).boxed().collect(Collectors.toList());
            r.setProducts(productsService.getProductListByIds(list));
            report.add(r);
        }
        return report;
    }
}
