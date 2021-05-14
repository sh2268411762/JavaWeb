// document.getElementById("button").onclick = function () {
//     console.log("1");
//     document.getElementById("content").innerHTML = "孙豪";
// }
//
// $(function main() {
//     $("#content").on("mouseover", function () {
//         $("#content").html("孙豪");
//     });
//
//     $("#content").on("mouseout", function () {
//         $("#content").html("枳洛淮南");
//     });
// });

// $(function main() {
//     setInterval(function () {
//         let s1 = $(".s1");
//         let s2 = $(".s2");
//         s1.removeClass("s1").addClass("s2");
//         s2.removeClass("s2").addClass("s1");
//
//         let ball = $(".ball");
//         let top = parseInt(ball.css("top").slice(0, -2));
//         let left = parseInt(ball.css("left").slice(0, -2));
//         top += 10;
//         left += 10;
//         ball.css("top", top + "px");
//         ball.css("left", left + "px");
//
//
//     }, 1000 / 24);
// });


$(function main() {
    $("button").on("click", function () {
        let e = $("h1");

        e.html("豪sir");

        setTimeout(function () {
            e.html("枳洛淮南")
        }, 3000);
    });

});