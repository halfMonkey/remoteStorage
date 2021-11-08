package com.udacity.jwdnd.course1.cloudstorage.entity;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface FileMapper {
	
	@Select("SELECT * FROM FILES WHERE userid = #{userId}")
	List<File> getAllFiles(int userId);
	
	@Select("SELECT * FROM FILES WHERE fileid = #{fileId}")
	File getFile(int fileId);
	
	@Insert("INSERT INTO FILES (filename, contenttype, filesize, userid, filedata) VALUES(#{filename}, #{contenttype}, #{filesize}, #{userId}, #{filedata})")
    @Options(useGeneratedKeys = true, keyProperty = "fileId")
	int saveFile(File file);
	
	@Delete("DELETE FROM FILES WHERE fileId = #{fileID}")
	int deletFile(int fileId);
	
}
