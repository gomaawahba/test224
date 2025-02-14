package com.gomaa.test2.Controller;

import com.gomaa.test2.Entity.Users;
import com.gomaa.test2.UserService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/login")
    public String login(@RequestBody Users user) {
        return userService.Login(user);
    }

    @PostMapping("/register")
    public String register(@RequestBody Users user) {
        return userService.register(user);
    }

    @PutMapping("/update/{id}")
    public String update(@PathVariable Long id, @RequestBody Users user) {
        return userService.updateUser(id, user);
    }

    @PostMapping("/delete")
    public String deleta(@PathVariable Long id) {
        return userService.delete(id);
    }
    @GetMapping("/users")
    public ResponseEntity<List<Users>>getAllUseres(){
        return ResponseEntity.ok(UserService.getAllUsers());

    }


}
