package com.cts.service;

import java.util.List;

import com.cts.exceptions.UserNotFound;
import com.cts.model.User;

public interface UserService {
	public abstract String saveUser(User user);

	public abstract User updateUser(User user);

	public abstract User getUser(int userId) throws UserNotFound;

	public abstract List<User> getAllUsers();
}
