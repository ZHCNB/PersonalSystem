<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
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
    var flag1 = false; //用户名状态码
    var flag2 = false; //邮箱状态码
    $(function () {
        //验证用户名是否重复
        $("#username").blur(function () {
            var username = $("#username").val();
            if (username == null || username == ""){
                alert("输入不能为空");}
            else {
                $.ajax({
                    url: "/checkUsername",
                    data: {
                        "username": username
                    },
                    dataType: "json",
                    type: "post",
                    success: function (msg) {
                        if (msg)
                            alert("用户名被占用");
                        else
                            flag1 = true;
                    }
                })
            }
        })

        //验证输入邮箱的格式
        $("#email").blur(function () {
            alert("验证邮箱")
            var email = $("#email").val();
            var emailFormat = new RegExp(/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/);
            if(email == null || email == "")
                alert("输入不能为空");
            else{
                alert(emailFormat.test(email))
                if(emailFormat.test(email))
                    flag2 = true;
                else
                    alert("邮箱格式不对");
            }
        })

        $("#regist-submit").on("click", function () {
            if(flag1 && flag2)
                $("#registForm").submit();
        })
    })
</script>


<body>
<div class="main_box">
    <table class="table">
        <h2>Register</h2>
        <form action="/register" method="post" id="registForm">
            <div class="form-group">
                <input type="text" class="form-control" id="username" name="username" placeholder="Username" autocomplete="off">
            </div>
            <div class="form-group">
                <input type="password" class="form-control" id="password" name="password" placeholder="Password" autocomplete="off">
            </div>
            <div class="form-group">
                <input type="email" class="form-control" id="email" name="email" placeholder="Email" autocomplete="off">
            </div>
            <div class="form-group">
                <input type="button" id="regist-submit" class="btn btn-default" value="注册">
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
