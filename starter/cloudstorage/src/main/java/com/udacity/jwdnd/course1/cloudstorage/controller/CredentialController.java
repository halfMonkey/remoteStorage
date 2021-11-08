package com.udacity.jwdnd.course1.cloudstorage.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.udacity.jwdnd.course1.cloudstorage.entity.Credential;
import com.udacity.jwdnd.course1.cloudstorage.entity.CredentialMapper;
import com.udacity.jwdnd.course1.cloudstorage.services.CrendentialService;

@Controller
public class CredentialController {

	private CrendentialService crendentialService;
	
	public CredentialController(CrendentialService crendentialService) {
		this.crendentialService = crendentialService;
	}



	@PostMapping("/credentials")
	String saveCredentials(Credential credential, Authentication authentication) {
		if(credential.getCredentialId() != null)
			this.crendentialService.updateCredential(credential, authentication.getName());
		else
			this.crendentialService.saveCredential(credential, authentication.getName());
		return "redirect:/home";
	}
	
	@GetMapping("/credentials/delete/{credentialId}")
	String deleteCredential(@PathVariable String credentialId) {
		this.crendentialService.deleteCredential(Integer.valueOf(credentialId));
		return "redirect:/home";
	}
}
