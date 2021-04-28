function load() {
    alert("OK");
}

$(function () {
    alert("KOOK");
    //方法的传入参数是json 格式对象
    let data = {
        username: "abc",
        password: "123"
    }
    $.ajax({
        type: "POST",//请求方法
        url: "data/login.json",//请求路径
        contentType: "application/json",//请求的数据类型
        data: JSON.stringify(data),//请求数据
        success: function (r) {
            alert(JSON.stringify(r));
        }, error: function (jqXHR, textStatus, errorThrown) {
            console.log("jqXHR={\n" + jqXHR.status + ",\n" + jqXHR.statusText + "},\ntextStatus="
                + textStatus + ",\nerrorThrown=" + errorThrown);
        }
    });
});