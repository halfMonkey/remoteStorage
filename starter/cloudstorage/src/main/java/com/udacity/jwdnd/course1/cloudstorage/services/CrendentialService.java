package com.udacity.jwdnd.course1.cloudstorage.services;

import java.security.SecureRandom;
import java.util.Base64;
import java.util.List;

import org.springframework.stereotype.Service;

import com.udacity.jwdnd.course1.cloudstorage.entity.Credential;
import com.udacity.jwdnd.course1.cloudstorage.entity.CredentialMapper;
import com.udacity.jwdnd.course1.cloudstorage.entity.User;
import com.udacity.jwdnd.course1.cloudstorage.entity.UserMapper;

@Service
public class CrendentialService {
	private UserMapper userMapper;
	private CredentialMapper credentialMapper;
	private EncryptionService encryptionService;
	
	public CrendentialService(UserMapper userMapper, CredentialMapper credentialMapper, EncryptionService encryptionService) {
		this.userMapper = userMapper;
		this.credentialMapper = credentialMapper;
		this.encryptionService = encryptionService;
	}
	
	
	public int saveCredential(Credential credential, String userName) {
		if(credential.getPassword().toCharArray().length < 2) return -1;
		
		User user = userMapper.getUser(userName);
		SecureRandom random = new SecureRandom();
		byte[] bytes = new byte[16];
		random.nextBytes(bytes);
		String token = Base64.getEncoder().encodeToString(bytes);
		String encryPassword = this.encryptionService.encryptValue(credential.getPassword(), token);
		
		return this.credentialMapper.saveCredential(new Credential(null, credential.getUrl(),credential.getUsername(),token, encryPassword, user.getUserId()));
	}
	
	public List<Credential> getCredentials(String userName){
		User user = userMapper.getUser(userName);
		return this.credentialMapper.getAllCredentials(user.getUserId());
	}
	
	public int updateCredential(Credential credential, String userName) {
		User user = userMapper.getUser(userName);
		SecureRandom random = new SecureRandom();
		byte[] bytes = new byte[16];
		random.nextBytes(bytes);
		String token = Base64.getEncoder().encodeToString(bytes);
		String encryPassword = this.encryptionService.encryptValue(credential.getPassword(), token);
		return this.credentialMapper.updateCredential(new Credential(credential.getCredentialId(), credential.getUrl(), credential.getUsername(), token, encryPassword, user.getUserId()));
	}
	
	public int deleteCredential(int credentialId) {
		return this.credentialMapper.deleteCredential(credentialId);
	}
}
