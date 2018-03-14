package com.zhc.blog.controller;

import com.zhc.admin.pojo.User;
import com.zhc.blog.pojo.Article;
import com.zhc.blog.pojo.Type;
import com.zhc.blog.service.ArticleService;
import com.zhc.blog.service.CommentService;
import com.zhc.blog.service.TypeService;
import com.zhc.file.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 *
 * 文章管理
 *
 */
@Controller
@RequestMapping("admin/article")
public class ArticleController {


    @Autowired
    private ArticleService articleService;

    @Autowired
    private TypeService typeService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private FileService fileService;

    @RequestMapping("index")
    public ModelAndView firstPage(){
        ModelAndView mv = new ModelAndView();
        int articleNums = articleService.articleSelectNums();
        int commentNums = commentService.commentNums();
        int fileNums = fileService.fileNums();
        mv.addObject("articleNums",articleNums);
        mv.addObject("commentNums",commentNums);
        mv.addObject("fileNums",fileNums);

        mv.setViewName("blog/index");
        return mv;
    }

    /**
     * @Author : zhc
     * @Decription: 发布文章界面
     * @return : 
     * @Date : 15:23 2017/12/28 0028
     */
    @RequestMapping("publish")
    public ModelAndView articleEditPage(){
        //得到文章类型列表
        ModelAndView mv = new ModelAndView();
        List<Type> typeList = typeService.typeList();
        mv.addObject("typeList", typeList);
        mv.setViewName("blog/article_edit");
        return mv;
    }
    /**
     * @Author : zhc
     * @Decription: 文章管理界面，获取所有文章
     * @return :
     * @Date : 15:31 2017/12/28 0028
     */
    @RequestMapping("manage")
    public ModelAndView articleManagePage(){
        ModelAndView mv = new ModelAndView();
        List<Article> list = null;
        list = articleService.articleList();
        mv.addObject("articleList", list);
        mv.setViewName("blog/article_manage");
        return mv;
    }

    /**
     * 保存文章
     *
     */
    @RequestMapping("saveArticle")
    @ResponseBody
    public boolean saveArticle(Article article, HttpSession session){
        User user = (User) session.getAttribute("user");
        article.setAuthorId(user.getId());
        article.setStatus("pulish");       //文章默认为发表
        article.setHits(0);             //点击量默认为0
        article.setCommentsNum(0);      //评论数默认为0
        articleService.save(article);
        return true;
    }

    /**
     * 更新文章
     */
    @RequestMapping("modifyArticle")
    @ResponseBody
    public boolean modifyArticle(Article article){
        articleService.modifyArticle(article);
        return true;
    }

    /**
     * 编辑文章界面
     */
    @RequestMapping("/{aid}")
    public ModelAndView editorArticle(@PathVariable String aid){
        ModelAndView mv = new ModelAndView();
        Article article = articleService.articleFindById(Integer.valueOf(aid));
        mv.addObject("article", article);
        //得到文章类型列表
        List<Type> typeList = typeService.typeList();
        mv.addObject("typeList", typeList);
        mv.setViewName("blog/article_edit");
        return mv;
    }

    /**
     * 删除文章
     */
    @RequestMapping("delete")
    public String deleteArticle(@RequestParam("aid")String aid){
        articleService.deleteById(Integer.valueOf(aid));
        return "redirect:manage";
    }
}
