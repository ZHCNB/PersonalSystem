package com.zhc.file.dao;

import java.util.List;

import com.zhc.file.pojo.FilePojo;

public interface FileDao {
	public void save(FilePojo file);
	public void delete(int id);
	public List<FilePojo> selectAll();

	public int fileNums();
}
