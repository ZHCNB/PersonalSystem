package com.zhc.file.service;

import java.util.List;

import com.zhc.file.pojo.FilePojo;

public interface FileService {
	/**
	 * 保存文件到数据库
	 */
	void save(FilePojo file);
	List<FilePojo> selectAll();
	void delete(int id);

	public int fileNums();
}
