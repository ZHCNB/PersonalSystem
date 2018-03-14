package com.zhc.file.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhc.file.dao.FileDao;
import com.zhc.file.pojo.FilePojo;

@Service
public class FileServiceImpl implements FileService{

	/**
     * 自动注入持久层Dao对象
     */
    @Autowired
    private FileDao fileDao;
    
	@Override
	public void save(FilePojo file) {
		fileDao.save(file);
	}

	@Override
	public List<FilePojo> selectAll() {
		return fileDao.selectAll();
	}

	@Override
	public void delete(int id) {
		fileDao.delete(id);
	}

	@Override
	public int fileNums() {
		return fileDao.fileNums();
	}
}
