package com.cts.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.exceptions.UserNotFound;
import com.cts.model.User;
import com.cts.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	UserRepository repository;

	@Override
	public String saveUser(User user) {
		log.info("In UserServiceImpl saveUser method ....");
		repository.save(user);
		return "User Saved";
	}

	@Override
	public User updateUser(User user) {
		log.info("In UserServiceImpl updateUser method ....");

		return repository.save(user);
	}

	@Override
	public User getUser(int userId) throws UserNotFound {
		log.info("In UserServiceImpl getUser method ....");
		Optional<User> optional = repository.findById(userId);
		if (optional.isPresent())
			return optional.get();
		else
			throw new UserNotFound("Invalid User Id !!!");
	}

	@Override
	public List<User> getAllUsers() {
		log.info("In UserServiceImpl getAllUser method ....");

		return repository.findAll();
	}

}
