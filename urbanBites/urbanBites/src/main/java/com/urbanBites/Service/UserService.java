package com.urbanBites.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.urbanBites.urbanBites.User;
import com.urbanBites.urbanBites.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    
 
    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    public ResponseEntity<User> getUserById(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        return userOptional.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<User> registerUser(User user) {
    	
        User savedUser = userRepository.save(user);
        return ResponseEntity.ok(savedUser);
    }

}
