function load() {
    alert("OK");
}

$(function () {
    alert("KOOK");
    //方法的传入参数是json 格式对象
    let data = {
        username:"abc",
        password:"123"
    }
    $.ajax({
        type:"POST",//请求方法
        url:"some.php",//请求路径
        contentType:"application/json",//请求的数据类型
        data:JSON.stringify(data),//请求数据
        success:function (msg) {
            alert("Data Saved:" + msg);
        }
    });
});