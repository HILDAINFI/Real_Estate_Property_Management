package com.cts;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.cts.exceptions.UserNotFound;
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
		User user = new User(52, "Linda", "linda@gmail.com", "123456", "admin", 987654);
		Mockito.when(repository.save(user)).thenReturn(user);

		String response = service.saveUser(user);
		assertEquals("User Saved", response);
	}

	@Test
	void updateUserTest() {
		User user = new User(52, "infant", "linda@gmail.com", "123456", "admin", 987654);
		Mockito.when(repository.save(user)).thenReturn(user);
		User response = service.updateUser(user);
		assertEquals(user, response);

	}

	@Test

	void getUserTest() throws UserNotFound {
		User user = new User(52, "Linda", "linda@gmail.com", "123456", "admin", 987654);
		Mockito.when(repository.findById(1)).thenReturn(Optional.of(user));
		User response = service.getUser(1);
		assertEquals(user, response);
	}

	@Test

	void getUserNotFoundTest() {
		Mockito.when(repository.findById(1)).thenReturn(Optional.empty());
		UserNotFound exception = assertThrows(UserNotFound.class, () -> service.getUser(1));
		assertEquals("Invalid User Id !!!", exception.getMessage());
	}

	@Test
	void getAllUsersTest() {

		User user1 = new User(52, "Linda", "linda@gmail.com", "123456", "admin", 987654);
		User user2 = new User(53, "Infi", "infi@gmail.com", "654321", "admin", 123456);
		List<User> users = Arrays.asList(user1, user2);
		Mockito.when(repository.findAll()).thenReturn(users);
		List<User> allUsers = service.getAllUsers();
		assertEquals(users, allUsers);
	}
}
