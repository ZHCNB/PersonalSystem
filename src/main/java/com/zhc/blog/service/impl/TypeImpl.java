package com.zhc.blog.service.impl;

import com.zhc.blog.dao.TypeDao;
import com.zhc.blog.pojo.Type;
import com.zhc.blog.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeImpl implements TypeService {

    @Autowired
    TypeDao typeDao;

    @Override
    public void typeDelete(int id) {
        typeDao.deleteTypeById(id);
    }

    @Override
    public List<Type> typeList() {
        return typeDao.typeList();
    }

    @Override
    public void typeAdd(Type type) {
        typeDao.addArticleType(type);
    }
}
