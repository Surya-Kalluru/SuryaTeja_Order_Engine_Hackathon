package com.vcube.smsapp01.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vcube.smsapp01.model.User;
import com.vcube.smsapp01.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
	private final UserService userService;
	
	@PostMapping("insertUser")
	 public User createUser(@RequestBody User user){	 
		return userService.createUser(user);	
	}
	
	@GetMapping("getUser")
	public List<User> getAllUser(){	
		return userService.getAllUsers();		
	}
	
	
	@GetMapping("getUserByid/{id}")
	public User getUserById(@PathVariable Integer id){
		return userService.getUserById(id);	
	}
	
	@PutMapping("/updateUser/{id}")
	public User updateUser(@RequestBody User user,@PathVariable Integer id){
		return userService.updateUser(user,id);
		
	}
}
