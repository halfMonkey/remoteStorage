package com.udacity.jwdnd.course1.cloudstorage.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.udacity.jwdnd.course1.cloudstorage.entity.Note;
import com.udacity.jwdnd.course1.cloudstorage.entity.NoteMapper;
import com.udacity.jwdnd.course1.cloudstorage.entity.User;
import com.udacity.jwdnd.course1.cloudstorage.entity.UserMapper;

@Service
public class NoteService {
	private NoteMapper noteMapper;
	private UserMapper userMapper;
	
	
	
	public NoteService(NoteMapper noteMapper, UserMapper userMapper) {
		this.noteMapper = noteMapper;
		this.userMapper = userMapper;
	}

	public List<Note> getNotes(String userName){
		User user = this.userMapper.getUser(userName);
		return this.noteMapper.getAllNotes(user.getUserId());
	}
	
	public int saveNotes(Note note, String userName) {
		User user = this.userMapper.getUser(userName);
		return this.noteMapper.saveNote(new Note(null, note.getNoteTitle(), note.getNoteDescription(), user.getUserId()));
	}
	
	public int updateNote(Note note, String userName) {
		User user = this.userMapper.getUser(userName);
		return this.noteMapper.updateNote(note);
	}
	
	public int deleteNote(int noteId) {
		return this.noteMapper.deletNote(noteId);
	}
}
