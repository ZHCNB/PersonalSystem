<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>分类管理</title>
    <%@include file="header.jsp" %>

    <div class="row">
        <div class="col-sm-12">
            <h4 class="page-title" id="page-title">
                分类管理
            </h4>
        </div>
        <div class="col-md-12">
            <table class="table table-bordered">
                <thead>
                <tr>
                    <th width="25%">分类名称</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${typeList}" var="type">
                    <tr>
                        <td>${type.name}</td>
                        <td>
                            <a href="/admin/type/delete?id=${type.id}"
                               class="btn btn-danger btn-sm waves-effect waves-light m-b-5"
                            onclick="return confirm('是否确定删除？')">
                                <i class="fa fa-trash-o"></i>
                                <span>删除</span>
                            </a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <form action="/admin/type/add" method="post">
                <div class="form-group col-md-6" style="padding: 0 10px 0 0;">
                    <input name="name" id="name" type="name" class="form-control" placeholder="添加类型"
                           value=""/>
                    <input type="submit" id="putType" class="btn btn-primary waves-effect waves-light" value="保存"></input>
                </div>
            </form>
        </div>
    </div>

    <%@include file="footer.jsp" %>
