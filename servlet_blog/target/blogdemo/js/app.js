$(function () { //页面加载完成之后执行function代码
    $("#login_form").submit(function () {
        //ajax 自己发请求
        $.ajax({
            url: "../login", //请求的服务路径
            type: "post",    //请求方法
            //contentType:"",请求的数据类型，请求头，Content-Type，请求头
            data: $("#login_form").serialize(),//请求数据：使用序列化表单的数据
            dataType: "json",//请求的数据类型，不至于默认的表单提交格式，JSON需要指定
            success: function (r) {
                //响应体json字符串，会解析为方法参数
                if (r.success) {
                    //前端页面url直接跳转到某个路径
                    window.location.href = "../jsp/articleList.jsp";
                } else {
                    alert("错误码：" + r.code + "\n 错误消息：" + r.message);
                }
            }
        })

        //同一不执行表单的默认提交
        return false;
    })  //jquery，使用 (#id)通过id获取某个页面元素
})