package com.zhc.blog.service.impl;


import com.zhc.blog.dao.ArticleDao;
import com.zhc.blog.pojo.Article;
import com.zhc.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleImpl implements ArticleService {

    @Autowired
    private ArticleDao articleDao;

    @Override
    public void save(Article article) {
        articleDao.save(article);
    }

    @Override
    public List<Article> articleList() {
        return articleDao.articleList();
    }

    @Override
    public Article articleFindById(int aid) {
        return articleDao.articleFindById(aid);
    }

    @Override
    public void deleteById(int aid) {
        articleDao.deleteById(aid);
    }

    @Override
    public void modifyArticle(Article article) {
        articleDao.modifyArticle(article);
    }

    @Override
    public Article articleFindByUrl(String url) {
        return articleDao.articleFindByUrl(url);
    }

    @Override
    public void articleHits(String url) {
        articleDao.articleHits(url);
    }

    @Override
    public void articleCommentsNum(int aid) {
        articleDao.articleCommentsNum(aid);
    }

    @Override
    public int articleSelectNums() {
        return articleDao.articleNums();
    }
}
