package com.zhc.blog.service.impl;

import com.zhc.blog.dao.CommentDao;
import com.zhc.blog.pojo.Comment;
import com.zhc.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentImpl implements CommentService {

    @Autowired
    CommentDao commentDao;

    @Override
    public List<Comment> articleComment(int aid) {
        return commentDao.articleComment(aid);
    }

    @Override
    public void saveComment(Comment comment) {
        commentDao.saveComment(comment);
    }

    @Override
    public List<Comment> AllComments() {
        return commentDao.allComments();
    }

    @Override
    public void deleteComment(int id) {
        commentDao.deleteComment(id);
    }

    @Override
    public int commentNums() {
        return commentDao.commentNums();
    }
}
