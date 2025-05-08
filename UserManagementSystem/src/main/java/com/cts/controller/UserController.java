package com.cts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.exceptions.UserNotFound;
import com.cts.model.User;
import com.cts.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService service;

	@PostMapping("/save")
	public String saveUser(@RequestBody User user) {
		return service.saveUser(user);
	}

	@PutMapping("/update")
	public User updateUser(@RequestBody User user) {
		return service.updateUser(user);
	}

	@GetMapping("/fetchById/{userid}")
	public User getUser(@PathVariable("userid") int userId) throws UserNotFound {
		return service.getUser(userId);
	}

	@GetMapping("/fetchAll")
	public List<User> getAllUsers() {
		return service.getAllUsers();
	}

}
