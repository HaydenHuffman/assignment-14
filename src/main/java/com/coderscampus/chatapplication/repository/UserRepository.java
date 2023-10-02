package com.coderscampus.chatapplication.repository;



import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.coderscampus.chatapplication.domain.User;

@Repository
public class UserRepository {
	

	private Set<User> users;

	public void save(User user) {
		users.add(user);
		
	}

	public Optional<User> findByUsername(String username) {
		for (User user : users) {
			if (user.getUsername().equals(username)) {
				return Optional.of(user);
			}
		}
		return Optional.empty();
	}

	
	



}
