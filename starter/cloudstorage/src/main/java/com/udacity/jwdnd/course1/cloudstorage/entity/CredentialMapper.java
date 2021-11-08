package com.udacity.jwdnd.course1.cloudstorage.entity;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface CredentialMapper {

	
	@Select("SELECT * FROM CREDENTIALS WHERE userid = #{userId}")
	List<Credential> getAllCredentials(int userId);
	
	
	@Insert("INSERT INTO CREDENTIALS (url, username, token, password, userid) VALUES(#{url}, #{username}, #{token}, #{password}, #{userId})")
	int saveCredential(Credential credential);
	
	@Delete("DELETE FROM CREDENTIALS WHERE credentialid = #{credentialId} ")
	int deleteCredential(int credentialId);
	
	@Update("UPDATE CREDENTIALS SET url = #{url}, username = #{username}, token = #{token}, password = #{password}, userid = #{userId} WHERE credentialid = #{credentialId}")
	int updateCredential(Credential credential);

}
