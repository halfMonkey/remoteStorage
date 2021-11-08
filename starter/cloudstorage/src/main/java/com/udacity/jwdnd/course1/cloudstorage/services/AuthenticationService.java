package com.udacity.jwdnd.course1.cloudstorage.services;

import java.util.ArrayList;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

import com.udacity.jwdnd.course1.cloudstorage.entity.User;
import com.udacity.jwdnd.course1.cloudstorage.entity.UserMapper;

@Service
public class AuthenticationService implements AuthenticationProvider {

	private HashService hashService;
	private UserMapper userMapper;

	public AuthenticationService(UserMapper userMapper,HashService hashService) {
		this.hashService = hashService;
		this.userMapper = userMapper;

	}

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getName();
		String password = authentication.getCredentials().toString();

		User user = userMapper.getUser(username);
		if (user != null) {
			String encodedSalt = user.getSalt();
			String hashedPassword = hashService.getHashedValue(password, encodedSalt);
			if (user.getPassword().equals(hashedPassword)) {
				return new UsernamePasswordAuthenticationToken(username, password, new ArrayList<>());
			}
		}

		return null;
	}
	
	
	
	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
