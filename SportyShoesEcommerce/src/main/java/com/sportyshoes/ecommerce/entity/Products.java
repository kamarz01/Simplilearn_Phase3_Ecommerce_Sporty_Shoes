package com.sportyshoes.ecommerce.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "products")
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    @NonNull
    private String name;
    @Column
    @NonNull
    private String desc;
    @Column
    @NonNull
    private Long price;
    @Column
    @NonNull
    private String imagePath;
    @ManyToOne
    private Categories categories;
}
