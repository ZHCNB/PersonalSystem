package com.zhc.blog.controller;

import com.zhc.blog.dao.ArticleDao;
import com.zhc.blog.pojo.Article;
import com.zhc.blog.pojo.Comment;
import com.zhc.blog.service.ArticleService;
import com.zhc.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("admin/comment")
public class CommentController {

    @Autowired
    CommentService commentService;
    @Autowired
    ArticleService articleService;

    /*评论管理界面*/
    @RequestMapping("manage")
    public ModelAndView commentManage(){
        ModelAndView mv = new ModelAndView();
        List<Comment> commentList = commentService.AllComments();
        Article article = articleService.articleFindById(commentList.get(0).getAid());
        mv.addObject("commentList", commentList);
        mv.addObject("article", article);
        mv.setViewName("blog/comment_manage");
        return mv;
    }


    /*评论提交*/
    @RequestMapping("subComment")
    @ResponseBody
    public boolean saveComment(Comment comment){
        commentService.saveComment(comment);
        articleService.articleCommentsNum(comment.getAid());
        return true;
    }

    /*根据id删除评论*/
    @RequestMapping("delete")
    public String deleteComment(@RequestParam("id")String id){
        commentService.deleteComment(Integer.valueOf(id));
        /*评论数 - 1 */

        return "redirect:manage";
    }

}
