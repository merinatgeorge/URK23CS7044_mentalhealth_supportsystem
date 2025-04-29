package com.mentalhealth.supportsystem.controller;

import org.springframework.web.bind.annotation.*;
import com.mentalhealth.supportsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import com.mentalhealth.supportsystem.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.http.ResponseEntity;
import java.util.HashMap;
import java.util.Map;


@RequestMapping("/api/users")
@CrossOrigin("*")
@Controller
public class UserController {

    @Autowired
    private UserService userService;
    
    @GetMapping("/")
    public String showHomePage() {
        return "home"; // templates/home.html
    }
    @GetMapping("/register")
    public String showRegisterForm() {
        return "register";
    }
    @GetMapping("/login")
    public String showLoginPage() {
        return "index"; // Will load templates/index.html
    
    }
    @GetMapping("/dashboard")
    public String showDashboard() {
        return "dashboard"; // Static file
    }
    
    
    @PostMapping(produces = "application/json")
    public User registerUser(@RequestBody User user) {
         userService.saveUser(user);
         return user;
    }
    

@PostMapping("/login")
    @ResponseBody
    public ResponseEntity<?> loginUser(@RequestBody Map<String, String> loginRequest) {
        String email = loginRequest.get("email");
        String password = loginRequest.get("password");
        
        User user = userService.findByEmailAndPassword(email, password);
        
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", "Invalid email or password");
            return ResponseEntity.status(401).body(errorResponse);
        }
    }
}