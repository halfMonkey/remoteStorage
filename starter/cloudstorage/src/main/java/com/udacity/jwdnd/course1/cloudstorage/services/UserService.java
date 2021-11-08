package com.udacity.jwdnd.course1.cloudstorage.services;

import java.security.SecureRandom;
import java.util.Base64;

import org.springframework.stereotype.Service;

import com.udacity.jwdnd.course1.cloudstorage.entity.User;
import com.udacity.jwdnd.course1.cloudstorage.entity.UserMapper;

@Service
public class UserService {
	private final UserMapper userMapper;
	private final HashService hashService;
	
	public UserService(UserMapper userMapper, HashService hashService) {
		this.userMapper = userMapper;
		this.hashService = hashService;
	}
	
	public boolean isUsernameAvalible(String username) {
		return userMapper.getUser(username) == null;
	}
	
	public int creatUser(User user) {
		SecureRandom random = new SecureRandom();
		byte[] salt = new byte[16];
		random.nextBytes(salt);
		String encodeSalt = Base64.getEncoder().encodeToString(salt);
		String hashPassword = this.hashService.getHashedValue(user.getPassword(), encodeSalt);
		return userMapper.insert(new User(null, user.getUsername(), encodeSalt, hashPassword, user.getFirstName(), user.getLastName()));
	}
	
    public User getUser(String username) {
        return userMapper.getUser(username);
    }
	
}
