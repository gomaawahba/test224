package com.gomaa.test2.UserService;

import com.gomaa.test2.Entity.Users;
import com.gomaa.test2.UserRepository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private static UserRepo userRepo;



    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public static List<Users> getAllUsers() {
        return userRepo.findAll();
    }

    public String register(Users users){
        Users users1=userRepo.findByUsername(users.getUsername());

        if(users1==null){
            userRepo.save(users);
            return "ok";

        }
        return "Fail";

    }

    public String Login(Users users){
        Users users1=userRepo.findByUsername(users.getUsername());

        if(users1.getUsername()==users.getUsername()){
            return "Login OK";
        }
        return "Login Fail";
    }

    public String updateUser(Long id,Users users){
        Users users1=userRepo.findByUsername(users.getUsername());
        if(!(users1 ==null)){
            users.setUsername(users.getUsername());
            users.setPassword(users.getPassword());
            userRepo.save(users);
            return "Updated Sucessfully";


        }
        return "User Not Found";

    }

    public String delete(Long id){
        userRepo.deleteById(id);
        return "User Deleted";

    }
}
