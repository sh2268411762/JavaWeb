$(function main() {
    setInterval(function () {
        $.get("get-request",function (count){
            $("content").html(count);
        });
    },5000);
});