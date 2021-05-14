document.getElementById("button").onclick = function () {
    console.log("1");
    document.getElementById("content").innerHTML = "孙豪";
}

$(function main() {
    $("#content").on("mouseover", function () {
        $("#content").html("孙豪");
    });

    $("#content").on("mouseout", function () {
        $("#content").html("枳洛淮南");
    });
});