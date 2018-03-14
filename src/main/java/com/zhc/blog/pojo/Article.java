package com.zhc.blog.pojo;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * 文章
 *
 * @author 张华厂
 */

public class Article {
    private Integer aid; //文章主键id
    private Integer authorId;   //发布文章作者id
    private String title;       //文章标题
    private Integer hits;   //点击数
    private String url;    //文章路径
    private String content; //文章内容
    private String type;    //文章类别
    private String status;  //文章状态（草稿/已发布）
    private String tag;     //文章标签
    private Integer commentsNum;    //评论数
    private Integer allowComment;   //是否允许评论
    private Timestamp create_time;   //创建时间
    private Timestamp alter_time;    //最后一次修改时间

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getHits() {
        return hits;
    }

    public void setHits(Integer hits) {
        this.hits = hits;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Integer getCommentsNum() {
        return commentsNum;
    }

    public void setCommentsNum(Integer commentsNum) {
        this.commentsNum = commentsNum;
    }

    public Integer getAllowComment() {
        return allowComment;
    }

    public void setAllowComment(Integer allowComment) {
        this.allowComment = allowComment;
    }

    public Timestamp getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Timestamp create_time) {
        this.create_time = create_time;
    }

    public Timestamp getAlter_time() {
        return alter_time;
    }

    public void setAlter_time(Timestamp alter_time) {
        this.alter_time = alter_time;
    }

    @Override
    public String toString() {
        return "Article{" +
                "aid=" + aid +
                ", authorId=" + authorId +
                ", title='" + title + '\'' +
                ", hits=" + hits +
                ", url='" + url + '\'' +
                ", content='" + content + '\'' +
                ", type='" + type + '\'' +
                ", status='" + status + '\'' +
                ", tag='" + tag + '\'' +
                ", commentsNum=" + commentsNum +
                ", allowComment=" + allowComment +
                ", create_time=" + create_time +
                ", alter_time=" + alter_time +
                '}';
    }
}
