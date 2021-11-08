package com.udacity.jwdnd.course1.cloudstorage.controller;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.udacity.jwdnd.course1.cloudstorage.entity.File;
import com.udacity.jwdnd.course1.cloudstorage.services.FileService;

@Controller
public class FileController {
	private FileService fileService;
	public FileController(FileService fileService){
		this.fileService = fileService;
	}
	
	@PostMapping("/files")
	public String saveFile(@RequestParam("fileUpload") MultipartFile file, Authentication authentication){
		String userName = authentication.getName();
		this.fileService.saveFile(file, userName);
		return "redirect:/home";
	}
	
	@GetMapping("/files/view/{fileid}")
	public ResponseEntity<Resource> getFile(@PathVariable String fileid) {
		File file = this.fileService.getFile(Integer.valueOf(fileid));
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(new ByteArrayResource(file.getFiledata()));
	}
	
	@GetMapping("/files/delete/{fileid}")
	public String deletFile(@PathVariable String fileid) {
		this.fileService.deleteFile(Integer.valueOf(fileid));
		return "redirect:/home";
	}
	
}
