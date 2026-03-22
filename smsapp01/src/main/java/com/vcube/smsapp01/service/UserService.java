package com.vcube.smsapp01.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import com.vcube.smsapp01.model.User;
import com.vcube.smsapp01.repo.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Integer id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
    
   public User updateUser(User updateUser,Integer id){
	   User existingUser=userRepository.findById(id)
			   .orElseThrow(()->new RuntimeException("user not found"));
	   existingUser.setName(updateUser.getName());
	   existingUser.setEmail(updateUser.getEmail());
	return userRepository.save(existingUser);
    	
    }
}