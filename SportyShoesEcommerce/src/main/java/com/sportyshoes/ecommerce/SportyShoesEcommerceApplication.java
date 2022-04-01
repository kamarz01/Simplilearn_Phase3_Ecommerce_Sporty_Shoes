package com.sportyshoes.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
public class SportyShoesEcommerceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SportyShoesEcommerceApplication.class, args);
    }

}
