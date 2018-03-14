<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="icon" href="/static/images/head.ico">
<link rel="shortcut icon" href="/static/images/head.ico">

<link rel="stylesheet" href="/static/css/fonts/fontawesome/css/font-awesome.min.css">
<link rel="stylesheet" href="/static/plugins/bootstrap/3.3.7/css/bootstrap.css">
<link rel="stylesheet" href="/static/css/xenon-core.css">
<link rel="stylesheet" href="/static/css/xenon-forms.css">
<link rel="stylesheet" href="/static/css/xenon-components.css">
<link rel="stylesheet" href="/static/css/xenon-skins.css">
<link rel="stylesheet" href="/static/css/commemt.css">

<script src="/static/js/jquery-1.11.1.min.js"></script>
<script src="/static/plugins/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body class="page-body" style="overflow-x: hidden">
<div class="page-container">
    <div class="sidebar-menu toggle-others fixed" style="width: 250px">
        <div class="sidebar-menu-inner">
            <header class="logo-env">
                <!-- logo -->
                <div class="logo">
                    <a href="" class="logo-expanded">
                        <img src="/static/images/logo@2x.png" width="80" alt=""/>
                    </a>
                </div>
            </header>

            <ul id="main-menu" class="main-menu">
                <li class="active opened active">
                    <a href="/admin/article/index">
                        <i class="fa fa-dashboard"></i>
                        <span class="title">仪表盘</span>
                    </a>
                </li>
                <li>
                    <a href="/admin/article/publish">
                        <i class="fa fa-pencil-square-o"></i>
                        <span class="title">发布文章</span>
                    </a>
                </li>
                <li>
                    <a href="/admin/article/manage">
                        <i class="fa fa-list"></i>
                        <span class="title">文章管理</span>
                    </a>
                </li>
                <li>
                    <a href="/admin/file/list">
                        <i class="fa fa-cloud-upload"></i>
                        <span class="title">文件管理</span>
                    </a>
                </li>
                <li>
                    <a href="">
                        <i class="fa fa-cubes"></i>
                        <span class="title">其它管理</span>
                    </a>
                    <ul>
                        <li>
                            <a href="/admin/comment/manage">
                                <%--<li class="fa fa-comments"></li>--%>
                                <span class="title">评论管理</span>
                            </a>
                        </li>
                        <li>
                            <a href="/admin/type/manage">
                                <%--<li class="fa fa-tags"></li>--%>
                                <span class="title">分类/标签</span>
                            </a>
                        </li>
                    </ul>
                </li>
            </ul>

        </div>

    </div>

    <div class="main-content">
        <!-- User Info, Notifications and Menu Bar -->
        <nav class="navbar user-info-navbar" role="navigation">
            <!-- Left links for user info navbar -->
            <ul class="user-info-menu left-links list-inline list-unstyled">
                <li class="hidden-sm hidden-xs">
                    <a href="#" data-toggle="sidebar">
                        <span class="fa-bars" style="font-size: 25px;"></span>
                    </a>
                </li>
            </ul>
            <!-- Right links for user info navbar -->
            <ul class="user-info-menu right-links list-inline list-unstyled">
                <li class="dropdown user-profile">
                    <a href="#" data-toggle="dropdown">
                        <img src="https://cn.gravatar.com/avatar/116128496960ed809734d6da88cefd26"
                             style="border: 2px solid #edf0f0; height: 36px; width: 36px; border-radius: 50%;"/>
                    </a>
                    <ul class="dropdown-menu user-profile-menu list-unstyled">
                        <li class="last">
                            <a href="/admin/logout">
                                <i class="fa-lock"></i> Logout
                            </a>
                        </li>
                    </ul>
                </li>
            </ul>

        </nav>