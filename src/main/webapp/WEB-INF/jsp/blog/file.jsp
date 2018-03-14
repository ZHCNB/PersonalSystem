<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 设置一个项目路径的变量 -->
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>--%>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>   --%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>文件管理</title>

    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <%@include file="header.jsp" %>
    <form action="/admin/file/Upload" method="post"
          enctype="multipart/form-data">
        <input type="file" name="file"/><br/>
        <input type="file" name="file"/><br/>
        <input type="file" name="file"/><br/>
        <input type="submit" value="上 传"/>
    </form>
    <br>
    <h5>上传结果：</h5>
    <table class="table table-striped table-bordered table-hover">
        <tbody>
        <tr>
            <th>文件名</th>
            <th>操作</th>
        </tr>
        <tr>
            <c:forEach items="${list}" var="me">
            <c:url value="/admin/file/down" var="downurl">
                <c:param name="filename" value="${me.name}"></c:param>
            </c:url>
            <td>${me.name}</td>
            <td>
                <a href="${downurl}">
                    <button class="btn btn-primary btn-sm">下载</button>
                </a>
                <a href="/admin/file/delete?id=${me.id }">
                    <button class="btn btn-danger btn-sm">删除</button>
                </a>
            </td>
        </tr>
        </c:forEach>
        </tbody>
    </table>
    <%-- <span>共${page.pages }页</span>
    <c:if test="${page.isFirstPage ==false}">
        <a href="admin/file/list?page=${page.firstPage }">首页</a>
        <a href="admin/file/list?page=${page.prePage }">上一页</a>
    </c:if>
    <c:if test="${page.isLastPage ==false}">
        <a href="admin/file/list?page=${page.nextPage }">下一页</a>
        <a href="admin/file/list?page=${page.lastPage }">尾页</a>
    </c:if> --%>
    <p>共 <fmt:formatNumber type="number" value="${page.last/page.count+1 }" maxFractionDigits="0"/> 页
        第 <fmt:formatNumber type="number" value="${page.start/page.count+1 }" maxFractionDigits="0"/>页</p>
    <c:if test="${page.start!=0 }">
    <a href="admin/file/list?start=0">首 页</a>
    <a href="admin/file/list?start=${page.start-page.count}">上一页</a>
    </c:if>
    <c:if test="${page.start!=page.last }">
    <a href="admin/file/list?start=${page.start+page.count}">下一页</a>
    <a href="admin/file/list?start=${page.last}">末 页</a>
    </c:if>
    <%@include file="footer.jsp" %>
