package com.zhc.blog.service;

import com.zhc.blog.pojo.Comment;

import java.util.List;

public interface CommentService {

    public void saveComment(Comment comment);

    public List<Comment> articleComment(int aid);

    public List<Comment> AllComments();

    public void deleteComment(int id);

    public  int commentNums();
}
