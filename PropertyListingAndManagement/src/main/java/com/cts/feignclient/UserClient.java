package com.cts.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cts.dto.UserInfo;



@FeignClient(name = "SECURITY-SERVICE", path = "/auth")
public interface UserClient {
	@PostMapping("/new") // http://localhost:9091/auth/new
	public String addNewUser(@RequestBody UserInfo userInfo);

	@GetMapping("/fetchById/{uid}") // http://localhost:9091/auth/fetchById/{id}
	public UserInfo getUserById(@PathVariable("uid") int SellerId);
}
