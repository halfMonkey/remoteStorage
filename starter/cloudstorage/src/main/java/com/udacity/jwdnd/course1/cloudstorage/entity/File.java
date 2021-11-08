package com.udacity.jwdnd.course1.cloudstorage.entity;

public class File {
	private Integer fileId;
	private String filename;
	private String contenttype;
	private String filesize;
	private Integer userId;
	private byte[] filedata;
	public File(Integer fileId, String filename, String contenttype, String filesize, Integer userId, byte[] filedata) {
		this.fileId = fileId;
		this.filename = filename;
		this.contenttype = contenttype;
		this.filesize = filesize;
		this.userId = userId;
		this.filedata = filedata;
	}
	public int getFileId() {
		return fileId;
	}
	public void setFileId(int fileId) {
		this.fileId = fileId;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getContenttype() {
		return contenttype;
	}
	public void setContenttype(String contenttype) {
		this.contenttype = contenttype;
	}
	public String getFilesize() {
		return filesize;
	}
	public void setFilesize(String filesize) {
		this.filesize = filesize;
	}
	public int getUserid() {
		return userId;
	}
	public void setUserid(int userId) {
		this.userId = userId;
	}
	public byte[] getFiledata() {
		return filedata;
	}
	public void setFiledata(byte[] filedata) {
		this.filedata = filedata;
	}
	
}
