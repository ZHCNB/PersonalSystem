package com.zhc.blog.service;

import com.zhc.blog.pojo.Type;

import java.util.List;

public interface TypeService {

    public List<Type> typeList();

    public  void typeDelete(int id);

    public  void typeAdd(Type type);
}
