package com.cts.feignclient;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cts.dto.User;

@FeignClient(name = "USERMANAGEMENTSYSTEM",path="/user")
public interface UserClient {
	@PostMapping("/save")
	public String saveUser(@RequestBody User user);
	
	@GetMapping("/fetchById/{userid}")
	public User getUserById(@PathVariable("userid") int userId);
}
