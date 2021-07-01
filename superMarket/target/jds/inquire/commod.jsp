<%--
  Created by IntelliJ IDEA.
  User: AI
  Date: 2021/6/11
  Time: 10:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=gb2312" import="java.sql.*" %>
<HTML>
<head><title>商品查询</title></head>

<BODY background="../image/07.jpg" style="background-repeat: no-repeat;background-attachment:
fixed;background-size: 100% 100%;">
<CENTER>
    <FONT SIZE=8 COLOR=#ff1493><strong>商品查询</strong></FONT>
</CENTER>
<HR>
<CENTER>
    <%!

        String driverName = "com.mysql.jdbc.Driver";
        //要连接的数据库URL
        String uri = "jdbc:mysql://localhost:3306/db_jxc_swing";
        //连接的数据库时使用的用户名
        String user = "root";
        //连接的数据库时使用的密码
        String password = "sunhao2268411762";
        Connection con;
        Statement stmt;
        ResultSet rs;%>
    <%
        try
        {
            //1.加载驱动
            //DriverManager.registerDriver(new com.mysql.jdbc.Driver());不推荐使用这种方式来加载驱动
            Class.forName(driverName);//推荐使用这种方式来加载驱动
            //2.获取与数据库的链接
            con = DriverManager.getConnection(uri, user, password);
            System.out.print("连接成功!");
            //3.获取用于向数据库发送sql语句的statement
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            //4.向数据库发sql,并获取代表结果集的resultset
            rs = stmt.executeQuery("SELECT * FROM tb_goods"); //建立ResultSet(结果集)对象，并执行SQL语句
            rs.last(); //移至最后一条记录
        } catch (ClassNotFoundException e)
        {
            System.out.print("连接失败!");
            e.printStackTrace();
        }
    %>
    <br><strong>
    数据表中共有
    <FONT SIZE=4 COLOR=red>
        <!--取得最后一条记录的行数-->
        <%=rs.getRow()%>
    </FONT>
    笔记录</strong>
    <br>
    <TABLE border=1 bordercolor="#FF0000" bgcolor=#EFEFEF WIDTH=400>
        <TR bgcolor=CCCCCC ALIGN=CENTER>
            <TD>
                <B>记录条数</B>
            </TD>
            <TD>
                <B>商品编号</B>
            </TD>
            <TD>
                <B>商品名称</B>
            </TD>
            <TD>
                <B>产地</B>
            </TD>
            <TD>
                <B>规格</B>
            </TD>
            <TD>
                <B>包装</B>
            </TD>
            <TD>
                <B>生产批号</B>
            </TD>
            <TD>
                <B>批准文号</B>
            </TD>
            <TD>
                <B>商品描述</B>
            </TD>
            <TD>
                <B>商品价格</B>
            </TD>
            <TD>
                <B>供应商编号</B>
            </TD>
        </TR>
            <%
				rs.beforeFirst(); //移至第一条记录之前
				//5.取出结果集的数据,利用while循环配合next方法将数据表中的记录列出
				while (rs.next()) {
			%>
        <TR ALIGN=CENTER>
            <!--利用getRow方法取得记录的位置-->
            <TD>
                <B><%=rs.getRow()%>
                </B>
            </TD>
            <TD>
                <B><%=rs.getString("id")%>
                </B>
            </TD>
            <TD>
                <B><%=rs.getString("goodsname")%>
                </B>
            </TD>
            <TD>
                <B><%=rs.getString("produceplace")%>
                </B>
            </TD>
            <TD>
                <B><%=rs.getString("size")%>
                </B>
            </TD>
            <TD>
                <B><%=rs.getString("package")%>
                </B>
            </TD>
            <TD>
                <B><%=rs.getString("productcode")%>
                </B>
            </TD>
            <TD>
                <B><%=rs.getString("promitcode")%>
                </B>
            </TD>
            <TD>
                <B><%=rs.getFloat("price")%>
                </B>
            </TD>
            <TD>
                <B><%=rs.getString("providerid")%>
                </B>
            </TD>
            <TD>
                <B><%=rs.getInt("available")%>
                </B>
            </TD>
        </TR>
            <%
				}
				//6.关闭链接，释放资源
				rs.close();//关闭ResultSet对象
				stmt.close();//关闭Statement对象
				con.close();//关闭Connection对象
			%>

</CENTER>
<div class="href">
    <button class="btn btn-danger"><a id="inquire-href" href="inquire.html"><span>上一界面</span></a></button>
    <button class="btn btn-danger"><a id="index-href" href="../index.html"><span>回到首页</span></a></button>
</div>
</BODY>
</HTML>
