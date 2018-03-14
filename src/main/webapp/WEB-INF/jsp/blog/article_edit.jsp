<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>发布文章</title>
    <%@include file="header.jsp" %>

    <%--引入富文本编辑器summernote css js--%>
    <link href="/static/plugins/summernote/0.8.2/summernote.css" rel="stylesheet">
    <script src="/static/plugins/summernote/0.8.2/summernote.min.js"></script>
    <script src="/static/plugins/summernote/0.8.2/lang/summernote-zh-CN.js"></script>

    <style type="text/css">
        #page-title {
            padding: 20px;
            background-color: #eeeeee;
        }

        .clearfix {
            height: 10px;
        }

        .text-right {
            text-align: right;
        }

        .form-group input {
            background-color: #FAFAFA;
        }

        .form-control {
            background-color: #FAFAFA;
        }

        p {
            color: #000000;
        }

        .note-editor.note-frame {
            border: 0px solid #a9a9a9;
        }

        .note-popover .popover-content, .panel-heading.note-toolbar {
            padding: 0 0 5px 5px;
            margin: 0;
            text-align: center;
            background-color: #eeeeee;
        }

        .panel {
            padding: 0px;
        }

        .note-editable {
            border: 1px solid #FAFAFA;
        }

        .modal-content {
            z-index: 2000;
        }

    </style>
    <div class="row">
        <div class="col-sm-12">
            <h4 class="page-title" id="page-title">
                发布文章
            </h4>
        </div>
        <form id="articleForm">
            <div class="col-md-12">

                <input type="hidden" value="${article.aid}" id="aid"/>
                <input type="hidden" value="${article.authorId}" id="authorId" />
                <input type="hidden" value="${article.hits}" id="hits" />
                <input type="hidden" value="${article.status}" id="status" />
                <input type="hidden" value="${article.commentsNum}" id="commentsNum" />
                <input type="hidden" value="${article.allowComment}" id="allowComment" />
                <input type="hidden" value="${article.create_time}" id="create_time"/>
                <input type="hidden" value="${article.alter_time}" id="alter_time"/>

                <div class="form-group col-md-6" style="padding: 0 10px 0 0;">
                    <input class="form-control" placeholder="请输入文章标题（必须）" id="title" name="title" required
                           value="${article.title}"/>
                </div>

                <div class="form-group col-md-6" style="padding: 0 0 0 10px;">
                    <input class="form-control" placeholder="自定义访问路径，如：my-first-article " id="url" name="url"
                           value="${article.url}"/>
                </div>

                <div class="form-group col-md-6" style="padding: 0 10px 0 0;">
                    <input name="tags" id="tag" type="text" class="form-control" placeholder="请填写文章标签"
                           value="${article.tag}"/>
                </div>

                <div class="form-group col-md-6" style="padding: 0 0 0 10px;">
                    <select class="form-control" id="type">
                        <option>默认分类</option>
                        <c:forEach items="${typeList}" var="type">
                            <option>${type.name}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>

            <div class="form-group col-md-12  clearfix"></div>

            <div class="form-group col-md-12">
                <div class="summernote">${article.content}</div>
            </div>

            <div class="form-group col-md-12  clearfix"></div>
        </form>
        <div class="text-right col-md-12">
            <a class="btn btn-default waves-effect waves-light" href="/admin/article/manage">返回列表</a>
            <button type="button" id="putArticle" class="btn btn-primary waves-effect waves-light">
                保存文章
            </button>
            <button type="button" id="draftArticle" class="btn btn-warning waves-effect waves-light">
                存为草稿
            </button>
        </div>
    </div>

    <script src="/static/js/article.js"></script>
    <%@include file="footer.jsp" %>
