package com.mentalhealth.supportsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mentalhealth.supportsystem.model.User;
import com.mentalhealth.supportsystem.repository.UserRepository;

@Service
public class UserService {
      @Autowired
    private UserRepository userRepository;

    public User saveUser(User user) {
        userRepository.save(user);
        return user;
    }

    public User findByEmailAndPassword(String email, String password) {
        
        return userRepository.findByEmailAndPassword(email, password);
    }

    public User getLoggedInUser() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getLoggedInUser'");
    }
}
    
    
    

