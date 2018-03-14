<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>${article.title}</title>

    <%@ include file="left_nav.jsp" %>

    <div class="right">
        <div class="right-container">
            <article>
                <div class="meta">
                    <div class="date">
                        <i class="fa fa-calendar-o" aria-hidden="true"></i>
                        <time><fmt:formatDate value="${article.alter_time}" pattern="yyyy-MM-dd"/></time>
                    </div>
                    <div class="comment">
                        <a href="/">
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
                </div>
            </article>

            <div class="comments">
                <span class="comment-num">
                    <c:choose>
                        <c:when test="${article.commentsNum == 0}">
                            暂无评论
                        </c:when>
                        <c:otherwise>
                            已有${article.commentsNum}条评论
                        </c:otherwise>
                    </c:choose>
                    <c:forEach items="${commentList}" var="comment">
                        <ol class="comment-list">
                        <li>
                            <div>
                                <img class="avatar" src="/static/images/reply.png" alt="Leny" width="80" height="80">
                                <div class="comment-main">
                                    <p class="comment-at"></p>
                                    <p>${comment.content}</p>
                                    <div class="comment-meta">
                                        <span class="comment-author">
                                            <a href="">${comment.c_name}</a>
                                        </span>
                                        <time class="comment-time">
                                            <fmt:formatDate value="${comment.create_time}"
                                                            pattern="yyyy-MM-dd HH:mm:ss"/>
                                        </time>
                                        <span class="comment-reply">
                                            <a href="javascript:void(0);">回复</a>
                                        </span>
                                    </div>
                                </div>
                            </div>
                        </li>
                        </ol>
                    </c:forEach>


                </span>
                <div class="author_info">
                    <input type="hidden" name="aid" id="aid" value="${article.aid}"/>
                    <input type="text" class="c_input" name="c_name" id="c_name" placeholder="用户名" value=""/>
                    <input type="text" class="c_input" name="c_email" id="c_email" placeholder="电子邮箱" value=""/>
                </div>
                <textarea name="content" id="content" class="c_input" placeholder="在这里输入你的评论..."></textarea>
                <button type="submit" class="c_button" id="c_submit">提交评论</button>
            </div>

            <script type="text/javascript">

                $(function () {
                    var aid = $('#aid').val();
                    var c_name;
                    var c_email;
                    var content;

                    var flag1 = false;  //验证用户名是否为空
                    var flag2 = false;   //验证邮箱格式是否正确
                    var flag3 = false;   //验证内容是否为空

                    //验证用户名
                    $('#c_name').blur(function () {
                        c_name = $('#c_name').val();
                        if (c_name == "" || c_name == null)
                            alert("用户名不能为空");
                        else
                            flag1 = true;
                    })

                    //验证邮箱
                    var emailFormat = new RegExp(/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/);
                    $('#c_email').blur(function () {
                        c_email = $('#c_email').val();
                        if (c_email == null || c_email == "")
                            alert("邮箱不能为空");
                        else {
                            if (emailFormat.test(c_email))
                                flag2 = true;
                            else
                                alert("邮箱格式不对");
                        }
                    })

                    //验证内容
                    $('#content').blur(function () {
                        content = $('#content').val()
                        if (content == "" || content == null)
                            alert("内容不能为空");
                        else
                            flag3 = true;
                    })


                    $('#c_submit').on('click', function () {
                        //提交评论
                        if (flag1 && flag2 && flag3) {
                            var parent_id = 0;
                            $.ajax({
                                url: '/admin/comment/subComment',
                                data: {
                                    'aid': aid,
                                    'parent_id': parent_id,
                                    'c_name': c_name,
                                    'c_email': c_email,
                                    'content': content
                                },
                                dataType: "json",
                                type: "post",
                                success: function (msg) {
                                    if (msg) {
                                        alert("评论成功");
                                        window.location.href = "${article.url}";
                                    }
                                    else
                                        alert("评论失败");
                                }
                            })
                        }
                    });

                })


            </script>

            <footer class="footer">
                © 2018
                <a href="/">${article.title}</a>
                <strong>人生需要奋斗</strong>
            </footer>
        </div>
    </div>
    </body>
</html>
