<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>仪表盘</title>
    <%@include file="header.jsp"%>

    <div class="row">
        <div class="col-sm-12">
            <h4 class="page-title" id="page-title">
                仪表盘
            </h4>
        </div>
        <div class="col-md-12">
            <table class="table table-bordered">
                <thead>
                <tr>
                    <th width="33%">发表文章数</th>
                    <th width="33%">收到留言数</th>
                    <th width="33%">上传文件数</th>
                </tr>
                </thead>
                <tbody>
                    <td>${articleNums}</td>
                    <td>${commentNums}</td>
                    <td>${fileNums}</td>
                </tbody>
            </table>
        </div>
    </div>

<%@include file="footer.jsp"%>
