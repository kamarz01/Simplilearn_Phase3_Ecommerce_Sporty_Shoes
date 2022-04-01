package com.sportyshoes.ecommerce.service;

import com.sportyshoes.ecommerce.dto.User;
import com.sportyshoes.ecommerce.entity.Users;
import com.sportyshoes.ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public Users validateUserLogin(User user, String type){
        return repo.findUsersByUsernameAndPasswordAndUserType(user.getUsername(),user.getPassword(),type);
    }

    public boolean updateAdminPassword(User user){
        Optional<Users> admin = repo.findById(user.getId());
        if (admin.isPresent()){
            admin.get().setPassword(user.getPassword());
            repo.save(admin.get());
            return true;
        }
        return false;
    }

    public List<Users> getAllUsersByType(String userType){
        return repo.findAllByUserType(userType);
    }

    public List<Users> searchUsers(String name,String userType){
        return repo.findUsersByNameLike(name);
    }

    public Users addNewUser(User user){
        Users _u = new Users(user.getName(),user.getUsername(), user.getPassword(), "customer");
        return repo.save(_u);
    }

    public Users getUserById(int id){
        return repo.findById(id).get();
    }

    public Users changeAdminPassword(int id,String newPassword){
        Users user = this.getUserById(id);
        user.setPassword(newPassword);
        return repo.save(user);
    }

    public boolean deleteUserById(int id){
        try {
            repo.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
