package com.nasdaq.virtualstockexchange.service;

import java.util.List;

import com.nasdaq.virtualstockexchange.model.User;

public interface UserService {

	User createUser(User user);
	User updateUser(User user);
	List<User> getAllUser();
	User getUserById(int userId);
	void deleteUser(int userId);
}
