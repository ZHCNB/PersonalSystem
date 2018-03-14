package com.zhc.blog.dao;

import com.zhc.blog.pojo.Comment;

import java.util.List;

public interface CommentDao {

    /*根据id删除评论*/
    public void deleteComment(int id);

    /*保存评论*/
    public void saveComment(Comment comment);

    /*根据aid文章的一级评论列表*/
    public List<Comment> articleComment(int aid);

    /*获取所有评论*/
    public List<Comment> allComments();

    /*获取评论总数*/
    public  int commentNums();
}
