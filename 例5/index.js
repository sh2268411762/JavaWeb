$(function main() {
    let ol = ("#content");

    $("button").on("click", function () {
        $.get("test.txt", function (data) {
            console.log(data);


            ol.append("<li>" + data + "</li>");
        });
    });
});