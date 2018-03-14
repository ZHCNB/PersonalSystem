<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>评论管理</title>
    <%@include file="header.jsp" %>

    <div class="row">
        <div class="col-sm-12">
            <h4 class="page-title" id="page-title">
                评论管理
            </h4>
        </div>
        <div class="col-md-12">
            <table class="table table-bordered">
                <thead>
                <tr>
                    <th width="25%">评论内容</th>
                    <th width="8%">评论人</th>
                    <th>评论时间</th>
                    <th>评论人邮箱</th>
                    <th width="15%">评论文章</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                    <c:forEach items="${commentList}" var="comment">
                        <tr>
                            <td>
                                <a href="/${article.url}">${comment.content}</a>
                            </td>
                            <td>${comment.c_name}</td>
                            <td>
                                <fmt:formatDate value="${comment.create_time}" pattern="yyyy-MM-dd HH:mm:ss"/>
                            </td>
                            <td>${comment.c_email}</td>
                            <td>
                                <a href="/${article.url}">${article.title}</a>
                            </td>
                            <td>
                                <a href="/" class="btn btn-primary btn-sm waves-effect waves-light m-b-5">
                                    <i class="fa fa-edit"></i>
                                    <span>回复</span>
                                </a>
                                <a href="/admin/comment/delete?id=${comment.id}" class="btn btn-danger btn-sm waves-effect waves-light m-b-5"
                                onclick="return confirm('确定要删除吗？')">
                                    <i class="fa fa-trash-o"></i>
                                    <span>删除</span>
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>

    <%@include file="footer.jsp" %>
