package com.sportyshoes.ecommerce.dto;

import com.sportyshoes.ecommerce.entity.Products;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Report {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String totalPrice;
    private List<Products> products = new ArrayList<>();

}
