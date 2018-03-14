package com.zhc.file.pojo;

public class FilePojo {
	private int id;
	private String name;
	private int uid;
	private String path;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	@Override
	public String toString() {
		return "FileItem [id=" + id + ", name=" + name + ", uid=" + uid + ", path=" + path + "]";
	}
	
	
}
