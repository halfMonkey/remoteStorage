package com.udacity.jwdnd.course1.cloudstorage.entity;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface NoteMapper {
	
	@Select("SELECT * FROM NOTES WHERE userid = #{userId}")
	List<Note> getAllNotes(int userId);
	
	@Insert("INSERT INTO NOTES (notetitle, notedescription, userid) VALUES (#{noteTitle}, #{noteDescription}, #{userId})")
    @Options(useGeneratedKeys = true, keyProperty = "noteId")
	int saveNote(Note note);

	@Update("UPDATE NOTES SET notetitle = #{noteTitle}, notedescription = #{noteDescription} WHERE noteid = #{noteId}")
	int updateNote(Note note);
	
	@Delete("DELETE FROM NOTES WHERE noteid = #{noteId}")
	int deletNote(int noteId);

}
