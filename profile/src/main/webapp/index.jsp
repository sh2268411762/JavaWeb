<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%!
    //有 ！为类级别
    private int count;
%>
<%
    //方法级别
    count++;
    request.setCharacterEncoding("utf-8");
    String name = request.getParameter("name");
    if (name == null)
    {
        name = "枳洛淮南";
    }
%>

<!DOCTYPE html>
<html lang="">
<!-- 注释 -->
<em>
    斜体元素
</em>
<head>
    <meta charset="UTF-8">
    <title>个人名片</title>

    <link rel="stylesheet" href="css/style.css">

</head>

<body>
<div>
    <h1><%= name %>
    </h1>
    <p><strong>大</strong>学生</p>
</div>


<em>1</em><em>2</em><em>3</em>
<p>4</p>
<p>5</p>
<p>6</p>

<div class="hobby">
    <!-- ol：有序列表  ul：无序列表 -->
    <h2>这货的爱好</h2>
    <ul>
        <li><a href="https://blog.csdn.net/weixin_43520256/article/details/115347612">写代码</a></li>
        <li><a href="https://blog.csdn.net/weixin_43520256/article/details/109665028">打游戏</a></li>
        <li><a href="https://blog.csdn.net/weixin_43520256/article/details/106148431">打篮球</a></li>
        <li><a href="https://blog.csdn.net/weixin_43520256/article/details/115961511">看电影</a></li>
        <li>看电影</li>
    </ul>
</div>

<div>
    <h2>学习经历</h2>
    <ol>
        <li><a href="https://blog.csdn.net/weixin_43520256/article/details/115917383">小学</a></li>
        <li><a href="https://blog.csdn.net/weixin_43520256/article/details/115919317">初中</a></li>
        <li><a href="https://blog.csdn.net/weixin_43520256/article/details/115896139">高中</a></li>
        <li><a href="https://blog.csdn.net/weixin_43520256/article/details/115874951">大学</a></li>
        <li><a href='https://blog.csdn.net/weixin_43520256/article/details/115874951'>大学</a></li>
    </ol>
</div>
<p>7</p>
<p>8</p>
<p>9</p>
<p>10</p>
<p>11</p>
<p>12</p>
<p>13</p>
<p>14</p>
<p>15</p>

<img src="image/01.jpg"/>

<div id="first">
    Hello
</div>

<div id="second">
    World
</div>
</body>
</html>
