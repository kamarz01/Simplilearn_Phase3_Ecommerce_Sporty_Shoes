package com.sportyshoes.ecommerce.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private int id;
    private String name;
    private String username;
    private String password;
    private String userType;
}
