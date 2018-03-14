<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="/static/css/login.css">
    <link rel="stylesheet" href="/static/plugins/bootstrap/3.3.7/css/bootstrap.css">
    <!-- jQuery -->
    <script src="/static/js/jquery-3.2.1.min.js"></script>
    <!-- Bootstrap -->
    <script src="/static/plugins/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<script type="text/javascript">
    $(function () {
        $("#login-submit").on("click", function () {
            var username = $("#username").val();
            var password = $("#password").val();

            $.ajax({
                url: "/loginCheck",
                data: {
                    "username": username,
                    "password": password
                },
                dataType: "json",
                type: "post",
                success: function (msg) {
                    if (!msg)
                        alert("用户名或密码错误");
                    else
                        $("#loginForm").submit();
                }
            })
        })
    })
</script>

<body>
<div class="main_box">
    <table class="table">
        <h2>Login Blog</h2>
        <form action="/admin/index" method="post" id="loginForm">
            <div class="form-group">
                <input type="text" class="form-control" id="username" name="username" placeholder="Username"
                       autocomplete="off">
            </div>
            <div class="form-group">
                <input type="password" class="form-control" id="password" name="password" placeholder="Password"
                       autocomplete="off">
            </div>
            <div class="form-group">
                <input type="button" id="login-submit" class="btn btn-default" value="登录">
                <a href="/regist" class="btn btn-default">注册</a>
            </div>
        </form>
    </table>
</div>

<!-- 图片轮播 -->
<div class="slideshow">
    <div class="slideshow-image" style="background-image: url('/static/images/admin/1.jpg')"></div>
    <div class="slideshow-image" style="background-image: url('/static/images/admin/4.jpg')"></div>
    <div class="slideshow-image" style="background-image: url('/static/images/admin/3.jpg')"></div>
    <div class="slideshow-image" style="background-image: url('/static/images/admin/4.jpg')"></div>
</div>
</body>
</html>
