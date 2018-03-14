package com.zhc.blog.dao;

import com.zhc.blog.pojo.Type;

import java.util.List;

public interface TypeDao {

    /*获取所有类型*/
    public List<Type> typeList();

    /*添加类型*/
    public void addArticleType(Type type);

    /*根据id删除类型*/
    public void deleteTypeById(int id);
}
