package com.cts.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.exceptions.UserNotFound;
import com.cts.model.User;
import com.cts.repository.UserRepository;
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository repository;

	@Override
	public String saveUser(User user) {
		repository.save(user);
		return "User Saved";
	}

	@Override
	public User updateUser(User user) {
		
		return repository.save(user);
	}

	@Override
	public User getUser(int userId) throws UserNotFound {
		Optional<User> optional = repository.findById(userId);
		if (optional.isPresent())
			return optional.get();
		else
			throw new UserNotFound("Invalid User Id !!!");
	}

	@Override
	public List<User> getAllUsers() {
		
		return repository.findAll();
	}

}
