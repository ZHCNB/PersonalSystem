<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>文章管理</title>
    <%@include file="header.jsp" %>

    <div class="row">
        <div class="col-sm-12">
            <h4 class="page-title" id="page-title">
                文章管理
            </h4>
        </div>
        <div class="col-md-12">
            <table class="table table-bordered">
                <thead>
                <tr>
                    <th width="25%">文章标题</th>
                    <th width="15%">发布时间</th>
                    <th>浏览量</th>
                    <th>所属分类</th>
                    <th width="8%">发布状态</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <c:if test="${articleList != null}">
                    <c:forEach items="${articleList}" var="article">
                        <tr>
                            <td>
                                <a href="">${article.title}</a>
                            </td>
                            <td>
                                <fmt:formatDate value="${article.alter_time}" pattern="yyyy-MM-dd HH:mm:ss"/>
                            </td>
                            <td>${article.hits}</td>
                            <td>${article.type}</td>
                            <td>
                                <c:choose>
                                    <c:when test="${article.status == 'pulish'}">
                                        <span class="label label-success">已发布</span>
                                    </c:when>
                                    <c:otherwise>
                                        <span class="label label-default">草稿</span>
                                    </c:otherwise>
                                </c:choose>
                            </td>
                            <td>
                                <a href="/admin/article/${article.aid}" class="btn btn-primary btn-sm waves-effect waves-light m-b-5">
                                    <i class="fa fa-edit"></i>
                                    <span>编辑</span>
                                </a>
                                <a href="/admin/article/delete?aid=${article.aid}" class="btn btn-danger btn-sm waves-effect waves-light m-b-5">
                                    <i class="fa fa-trash-o"></i>
                                    <span>删除</span>
                                </a>
                                <c:if test="${article.status == 'draft'}">
                                    <a class="btn btn-warning btn-sm waves-effect waves-light m-b-5" href=""
                                       target="_blank">
                                        <i class="fa fa-rocket"></i>
                                        <span>预览</span>
                                    </a>
                                </c:if>
                            </td>
                        </tr>
                    </c:forEach>
                </c:if>
                </tbody>
            </table>
        </div>
    </div>

    <%@include file="footer.jsp" %>
