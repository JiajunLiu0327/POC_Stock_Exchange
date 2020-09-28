package com.nasdaq.virtualstockexchange.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.nasdaq.virtualstockexchange.model.User;
import com.nasdaq.virtualstockexchange.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	
	@Override
	public User createUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User updateUser(User user) {
		Optional<User> userDb = this.userRepository.findById(user.getId());
		
		if(userDb.isPresent()) {
			User userUpdate = userDb.get();
			userUpdate.setId(user.getId());
			userUpdate.setUserName(user.getUserName());
			userUpdate.setPassword(user.getPassword());
			userRepository.save(userUpdate);
			return userUpdate;
		}else {
			throw new ResourceNotFoundException("Record not found with id: "+user.getId());
		}
	}

	@Override
	public List<User> getAllUser() {
		return this.userRepository.findAll();
	}

	@Override
	public User getUserById(int userId) {
		Optional<User> userDb = this.userRepository.findById(userId);
		
		if(userDb.isPresent()) {
			return userDb.get();
		}else {
			throw new ResourceNotFoundException("Record not found with id: "+userId);
		}
	}

	@Override
	public void deleteUser(int userId) {
		Optional<User> userDb = this.userRepository.findById(userId);
		
		if(userDb.isPresent()) {
			this.userRepository.delete(userDb.get());
		}else {
			throw new ResourceNotFoundException("Record not found with id: "+userId);
		}
	}

}
