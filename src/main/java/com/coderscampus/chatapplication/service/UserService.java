package com.coderscampus.chatapplication.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderscampus.chatapplication.domain.User;
import com.coderscampus.chatapplication.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

    public Optional<User> findByUsername(String username) {
    	return userRepo.findByUsername(username);
    }

	public void save(User user) {
		userRepo.save(user);
		
	}



}
