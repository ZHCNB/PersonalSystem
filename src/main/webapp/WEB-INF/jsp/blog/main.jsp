<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>首页</title>

    <%@ include file="left_nav.jsp" %>

    <div class="right">
        <div class="right-container">
            <c:forEach items="${articleList}" var="article">
                <article>
                    <div class="meta">
                        <div class="date">
                            <i class="fa fa-calendar-o" aria-hidden="true"></i>
                            <time><fmt:formatDate value="${article.alter_time}" pattern="yyyy-MM-dd"/></time>
                        </div>
                        <div class="comment">
                            <a href="/${article.url}">
                                <c:choose>
                                    <c:when test="${article.commentsNum == 0}">
                                        暂无评论
                                    </c:when>
                                    <c:otherwise>
                                        ${article.commentsNum}次评论
                                    </c:otherwise>
                                </c:choose>
                                / ${article.hits}次浏览
                            </a>
                        </div>
                    </div>
                    <h1 class="title">
                        <a href="/${article.url}">${article.title}</a>
                    </h1>
                    <div class="entry-content">
                        <div class="content">
                                ${article.content}
                        </div>
                        <p>
                            <a href="/${article.url}">继续阅读 »</a>
                        </p>
                    </div>
                </article>
            </c:forEach>
            <footer class="footer">
                © 2018
                <a href="/">${article.title}</a>
                <strong>人生需要奋斗</strong>
            </footer>
        </div>
    </div>
</div>
</body>
</html>
