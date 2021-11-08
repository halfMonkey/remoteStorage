package com.udacity.jwdnd.course1.cloudstorage.services;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.udacity.jwdnd.course1.cloudstorage.entity.File;
import com.udacity.jwdnd.course1.cloudstorage.entity.FileMapper;
import com.udacity.jwdnd.course1.cloudstorage.entity.User;
import com.udacity.jwdnd.course1.cloudstorage.entity.UserMapper;

@Service
public class FileService {
	
	private FileMapper fileMapper;
	private UserMapper userMapper;
	
	public FileService(FileMapper fileMapper, UserMapper userMapper) {
		this.fileMapper = fileMapper;
		this.userMapper = userMapper;
	}

	public int saveFile(MultipartFile file, String userName) {
		User user = userMapper.getUser(userName);
		String name = file.getOriginalFilename();
		String size = String.valueOf(file.getSize());
		String type = "unknown";
		String[] tokens =  name.split(".");
		if(tokens.length >= 2) {
			type = tokens[tokens.length - 1];
		}
		
		byte[] data;
		try {
			data = file.getBytes();
			if(data.length / 1024 > 60) return -1; 
		} catch (IOException e) {
			return -1;
		}
		return fileMapper.saveFile(new File(null, name, type, size, user.getUserId(), data));
	}
	
	
	public List<File> getFiles(String userName){
		User user = this.userMapper.getUser(userName);
		if(user.getUserId() == null) return null;
		return this.fileMapper.getAllFiles(user.getUserId());
	}
	
	public File getFile(int fileId) {
		return this.fileMapper.getFile(fileId);
	}
	
	public int deleteFile(int fileId) {
		return this.fileMapper.deletFile(fileId);
	}
}
