package com.udacity.jwdnd.course1.cloudstorage.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.udacity.jwdnd.course1.cloudstorage.entity.Note;
import com.udacity.jwdnd.course1.cloudstorage.services.NoteService;

@Controller
public class NoteController {

	private NoteService noteService;
	
	
	public NoteController(NoteService noteService) {
		this.noteService = noteService;
	}


	@PostMapping("/notes")
	String saveNote(Note note, Authentication authentication) {
		if(note.getNoteId() != null)
			this.noteService.updateNote(note, authentication.getName());
		else
			this.noteService.saveNotes(note, authentication.getName());
		return "redirect:/home";
	}
	
	@GetMapping("/notes/delete/{noteid}")
	String deleteNote(@PathVariable String noteid) {
		this.noteService.deleteNote(Integer.valueOf(noteid));
		return "redirect:/home";
	}
	
}
