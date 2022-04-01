package com.sportyshoes.ecommerce.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
public class Users {
    @Id
    private int id;
    @Column
    @NonNull
    private String name;
    @Column
    @NonNull
    private String username;
    @Column
    @NonNull
    private String password;
    @Column
    @NonNull
    private String userType;

    @OneToMany(mappedBy = "user")
    private List<Orders> orders;
}
