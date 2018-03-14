package com.zhc.blog.controller;

import com.zhc.admin.pojo.User;
import com.zhc.blog.pojo.Article;
import com.zhc.blog.pojo.Comment;
import com.zhc.blog.service.ArticleService;
import com.zhc.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 前端主页面
 */
@Controller
public class Main {

    @Autowired
    ArticleService articleService;

    @Autowired
    CommentService commentService;

    /**
     * 博客列表
     */
    @RequestMapping("main")
    public ModelAndView indexPage() {
        ModelAndView mv = new ModelAndView();
        List<Article> articleList = articleService.articleList();
        //提取内容中的纯文本
        for (Article article : articleList) {
            String htmlStr = article.getContent();
            String regEx_script = "<script[^>]*?>[\\s\\S]*?<\\/script>"; //定义script的正则表达式
            String regEx_style = "<style[^>]*?>[\\s\\S]*?<\\/style>"; //定义style的正则表达式
            String regEx_html = "<[^>]+>"; //定义HTML标签的正则表达式
            Pattern p_script = Pattern.compile(regEx_script, Pattern.CASE_INSENSITIVE);
            Matcher m_script = p_script.matcher(htmlStr);
            htmlStr = m_script.replaceAll(""); //过滤script标签

            Pattern p_style = Pattern.compile(regEx_style, Pattern.CASE_INSENSITIVE);
            Matcher m_style = p_style.matcher(htmlStr);
            htmlStr = m_style.replaceAll(""); //过滤style标签

            Pattern p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
            Matcher m_html = p_html.matcher(htmlStr);
            htmlStr = m_html.replaceAll(""); //过滤html标签

            article.setContent(htmlStr.trim().substring(0, 300)); //返回文本字符串
        }

        mv.addObject("articleList", articleList);

        mv.setViewName("blog/main");
        return mv;
    }

    /**
     * 文章详情显示
     *
     */
    @RequestMapping("/{url}")
    public ModelAndView article_detail(@PathVariable String url){
        ModelAndView mv = new ModelAndView();
        articleService.articleHits(url);   //文章浏览次数+1
        Article article = articleService.articleFindByUrl(url);
        mv.addObject("article", article);
        //根据文章aid查找该文章的所有评论
        List<Comment> commentList = commentService.articleComment(article.getAid());
        mv.addObject("commentList", commentList);
        mv.setViewName("blog/article_detail");
        return mv;
    }
}

