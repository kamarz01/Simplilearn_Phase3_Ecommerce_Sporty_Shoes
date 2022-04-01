package com.sportyshoes.ecommerce.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private String name;
    private String desc;
    private Long price;
    private int catId;
    private String image;
}
