package com.zhc.blog.pojo;

import java.sql.Timestamp;
import java.util.List;

public class Comment {
    private int id;     //评论id
    private int aid;    //文章id
    private int parent_id;  //父级评论id
    private String c_name; //  评论人用户名
    private String c_email; //评论人邮箱
    private Timestamp create_time;  //评论时间
    private String content; //评论内容


    private List<Comment> replyComment; // 评论回复信息


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public int getParent_id() {
        return parent_id;
    }

    public void setParent_id(int parent_id) {
        this.parent_id = parent_id;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public String getC_email() {
        return c_email;
    }

    public void setC_email(String c_email) {
        this.c_email = c_email;
    }

    public Timestamp getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Timestamp create_time) {
        this.create_time = create_time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Comment> getReplyComment() {
        return replyComment;
    }

    public void setReplyComment(List<Comment> replyComment) {
        this.replyComment = replyComment;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", aid=" + aid +
                ", parent_id=" + parent_id +
                ", c_name='" + c_name + '\'' +
                ", c_email='" + c_email + '\'' +
                ", create_time=" + create_time +
                ", content='" + content + '\'' +
                ", replyComment=" + replyComment +
                '}';
    }
}
