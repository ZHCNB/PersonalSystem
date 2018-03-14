package com.zhc.blog.dao;


import com.zhc.blog.pojo.Article;

import java.util.List;

public interface ArticleDao {
    /*保存文章*/
    public void save(Article article);

    /*获取所有文章*/
    public List<Article> articleList();

    /*根据id查找文章*/
    public Article articleFindById(int aid);

    /*根据id删除文章*/
    public void deleteById(int aid);

    /*根据id更新文章*/
    public void modifyArticle(Article article);

    /*根据url查找文章*/
    public Article articleFindByUrl(String url);

    /*文章浏览次数+1*/
    public void articleHits(String url);

    /*文章评论数+1*/
    public void articleCommentsNum(int aid);

    /*查询文章总数*/
    public int articleNums();
}
