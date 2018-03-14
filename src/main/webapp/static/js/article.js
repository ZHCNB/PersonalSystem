$(function(){
    //保存文章
    $("#putArticle").on("click", function () {
        // var text = $('.summernote').summernote();
        // alert(text);
        var aid = $('#aid').val();
        var authorId = $('#authorId').val();
        var hits = $('#hits').val();
        var status = $('#status').val();
        var commentsNum = $('#commentsNum').val();
        var allowComment = $('#allowComment').val();
        var create_time = $('#create_time').val();
        var alter_time = $('#alter_time').val();
        //包含样式content
        var content = $('.summernote').summernote('code');
        var title = $('#title').val();
        var url = $('#url').val();
        var tag = $('#tag').val();
        var type = $('#type option:selected').text();
        var requestUrl;
        if (aid != ''){
            //更新文章
            requestUrl = '/admin/article/modifyArticle';
            $.ajax({
                url:requestUrl,
                data:{
                    'aid':aid,
                    'authorId':authorId,
                    'hits':hits,
                    'status':status,
                    'commentsNum':commentsNum,
                    'allowComment':allowComment,
                    'create_time':create_time,
                    'alter_time':alter_time,
                    'content':content,
                    'title':title,
                    'tag':tag,
                    'type':type,
                    'url':url
                },
                dataType:"json",
                type:"post",
                success:function(msg){
                    if(msg){
                        alert("发表成功");
                        window.location.href="/admin/article/manage";
                    }
                    else
                        alert("发表失败");
                }
            })
        }
    else{
            //保存新文章
            requestUrl = '/admin/article/saveArticle';
            $.ajax({
                url:requestUrl,
                data:{
                    'content':content,
                    'title':title,
                    'tag':tag,
                    'type':type,
                    'url':url
                },
                dataType:"json",
                type:"post",
                success:function(msg){
                    if(msg){
                        alert("发表成功");
                        window.location.href="/admin/article/manage";
                    }
                    else
                        alert("发表失败");
                }
            })
        }
    })

    $('.summernote').summernote({
        lang: 'zh-CN',
        height: 300,
        placeholder: '写点儿什么吧...'
    });
})
