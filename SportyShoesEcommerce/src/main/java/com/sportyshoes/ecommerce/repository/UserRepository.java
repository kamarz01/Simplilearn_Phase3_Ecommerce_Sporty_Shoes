package com.sportyshoes.ecommerce.repository;

import com.sportyshoes.ecommerce.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<Users,Integer> {

    public Users findUsersByUsernameAndPasswordAndUserType(String username,String password,String userType);

    @Query("SELECT m FROM Users m WHERE lower(m.name) LIKE lower(concat('%', :name,'%')) AND m.userType='customer'")
    public List<Users> findUsersByNameLike(@Param("name") String name);

    public List<Users> findAllByUserType(String userType);

}
