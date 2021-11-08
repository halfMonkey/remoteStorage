package com.udacity.jwdnd.course1.cloudstorage.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.udacity.jwdnd.course1.cloudstorage.entity.Credential;
import com.udacity.jwdnd.course1.cloudstorage.entity.Note;
import com.udacity.jwdnd.course1.cloudstorage.services.CrendentialService;
import com.udacity.jwdnd.course1.cloudstorage.services.EncryptionService;
import com.udacity.jwdnd.course1.cloudstorage.services.FileService;
import com.udacity.jwdnd.course1.cloudstorage.services.NoteService;

@Controller
public class HomeController {
	private FileService fileService;
	private NoteService noteService;
	private CrendentialService crendentialService;
	private EncryptionService encryptionService;
	
	public HomeController(FileService fileService, NoteService noteService, CrendentialService crendentialService,EncryptionService encryptionService) {
		this.fileService = fileService;
		this.noteService = noteService;
		this.crendentialService = crendentialService;
		this.encryptionService = encryptionService;
	}

	@RequestMapping("/")
	String toHome() {
		return "redirect:/home";
	}

	@GetMapping("/home")
	String getHomePage(Credential credential, Note note, Model model, Authentication authentication) {
		model.addAttribute("files", this.fileService.getFiles(authentication.getName()));
		model.addAttribute("notes", this.noteService.getNotes(authentication.getName()));
		model.addAttribute("credentials", this.crendentialService.getCredentials(authentication.getName()));
		model.addAttribute("encryptionService", this.encryptionService);
		return "home";
	}
}
