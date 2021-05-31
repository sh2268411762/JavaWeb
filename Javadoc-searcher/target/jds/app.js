$(function () {
    $("#login_form").submit(function () {
        $.ajax({
            url:"../login",
            type:"post",
            dataType:"json",
            data:$("#login_form").serialize(),
            success:function (r) { //给前端返回的json
                if(r.success){
                    window.location.href="../index.html";
                }else{
                    alert("错误信息: "+r.msg);
                }
            }
        })
        return false;
    })

    $("#register_form").submit(function () {
        $.ajax({
            url:"../register",
            type:"post",
            dataType:"json",
            data:$("#register_form").serialize(),
            success:function (r) { //给前端返回的json
                if(r.success){
                    alert("注册状态: "+r.msg);
                    window.location.href="login.html";
                }else{
                    alert("错误信息: "+r.msg);
                }
            }
        })
        return false;
    })
})