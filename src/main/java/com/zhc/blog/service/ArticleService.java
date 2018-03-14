package com.zhc.blog.service;


import com.zhc.blog.pojo.Article;

import java.util.List;

public interface ArticleService {
    /**
     * 文章操作
     *
            */
    public void save(Article article);

    public List<Article> articleList();

    public Article articleFindById(int aid);

    public void deleteById(int aid);

    public void modifyArticle(Article article);

    public Article articleFindByUrl(String url);

    public void articleHits(String url);

    public void articleCommentsNum(int aid);

    public int articleSelectNums();
}
