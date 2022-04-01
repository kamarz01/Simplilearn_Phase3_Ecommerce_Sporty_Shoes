package com.sportyshoes.ecommerce.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
public class Order {
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String totalPrice;
    private String products;
    private int userId;

}
