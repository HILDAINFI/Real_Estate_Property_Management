package com.cts;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.apache.commons.math.stat.descriptive.summary.Product;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.cts.model.User;
import com.cts.repository.UserRepository;
import com.cts.service.UserServiceImpl;

@SpringBootTest
class UserManagementSystemApplicationTests {

	@Mock
	UserRepository repository;
 
	@InjectMocks
	UserServiceImpl service;
	
	@Test
	void saveUserTest() {
		User user = new User(0, "Hilda", "hi@gmail.com", "hilda", "admin",987654321);
		Mockito.when(repository.save(user)).thenReturn(user);
 
		String response = service.saveUser(user);
		assertEquals("Product Saved Successfully", response);
		
		
		
    		
	}
	

}
