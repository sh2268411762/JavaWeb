<%--
  Created by IntelliJ IDEA.
  User: AI
  Date: 2021/6/11
  Time: 10:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=gb2312" import="java.sql.*" %>
<HTML>
<head><title>�ͻ���ѯ</title></head>

<BODY background="../image/07.jpg" style="background-repeat: no-repeat;background-attachment:
fixed;background-size: 100% 100%;">
<CENTER>
    <FONT SIZE=8 COLOR=#ff1493><strong>�ͻ���ѯ</strong></FONT>
</CENTER>
<HR>
<CENTER>
    <%!
        String driverName = "com.mysql.jdbc.Driver";
        //Ҫ���ӵ����ݿ�URL
        String uri = "jdbc:mysql://localhost:3306/db_jxc_swing";
        //���ӵ����ݿ�ʱʹ�õ��û���
        String user = "root";
        //���ӵ����ݿ�ʱʹ�õ�����
        String password = "sunhao2268411762";
        Connection con;
        Statement stmt;
        ResultSet rs;%>
    <%
        try
        {
            //1.��������
            //DriverManager.registerDriver(new com.mysql.jdbc.Driver());���Ƽ�ʹ�����ַ�ʽ����������
            Class.forName(driverName);//�Ƽ�ʹ�����ַ�ʽ����������
            //2.��ȡ�����ݿ������
            con = DriverManager.getConnection(uri, user, password);
            System.out.print("���ӳɹ�!");
            //3.��ȡ���������ݿⷢ��sql����statement
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            //4.�����ݿⷢsql,����ȡ����������resultset
            rs = stmt.executeQuery("SELECT * FROM tb_customer"); //����ResultSet(�����)���󣬲�ִ��SQL���
            rs.last(); //�������һ����¼
        } catch (ClassNotFoundException e)
        {
            System.out.print("����ʧ��!");
            e.printStackTrace();
        }
    %>
    <br><strong>
    ���ݱ��й���
    <FONT SIZE=4 COLOR=red>
        <!--ȡ�����һ����¼������-->
        <%=rs.getRow()%>
    </FONT>
    �ʼ�¼</strong>
    <br>
    <TABLE border=1 bordercolor="#FF0000" bgcolor=#EFEFEF WIDTH=400>
        <TR bgcolor=CCCCCC ALIGN=CENTER>
            <TD>
                <B>�ͻ����</B>
            </TD>
            <TD>
                <B>�ͻ�ȫ��</B>
            </TD>
            <TD>
                <B>�ͻ��ʱ�</B>
            </TD>
            <TD>
                <B>�ͻ���˾��ַ</B>
            </TD>
            <TD>
                <B>�ͻ���˾�绰</B>
            </TD>
            <TD>
                <B>��ϵ��</B>
            </TD>
            <TD>
                <B>��ϵ�绰</B>
            </TD>
            <TD>
                <B>��������</B>
            </TD>
            <TD>
                <B>�����˺�</B>
            </TD>
            <TD>
                <B>��ϵ������</B>
            </TD>
            <TD>
                <B>�ͻ�����</B>
            </TD>
        </TR>
            <%
				rs.beforeFirst(); //������һ����¼֮ǰ
				//5.ȡ�������������,����whileѭ�����next���������ݱ��еļ�¼�г�
				while (rs.next()) {
			%>
        <TR ALIGN=CENTER>
            <!--����getRow����ȡ�ü�¼��λ��-->
            <TD>
                <B><%=rs.getRow()%>
                </B>
            </TD>
            <TD>
                <B><%=rs.getString("customername")%>
                </B>
            </TD>
            <TD>
                <B><%=rs.getString("zip")%>
                </B>
            </TD>
            <TD>
                <B><%=rs.getString("address")%>
                </B>
            </TD>
            <TD>
                <B><%=rs.getString("telephone")%>
                </B>
            </TD>
            <TD>
                <B><%=rs.getString("connectionperson")%>
                </B>
            </TD>
            <TD>
                <B><%=rs.getString("phone")%>
                </B>
            </TD>
            <TD>
                <B><%=rs.getString("bank")%>
                </B>
            </TD>
            <TD>
                <B><%=rs.getString("account")%>
                </B>
            </TD>
            <TD>
                <B><%=rs.getString("email")%>
                </B>
            </TD>
            <TD>
                <B><%=rs.getString("fax")%>
                </B>
            </TD>
        </TR>
            <%
				}
				//6.�ر����ӣ��ͷ���Դ
				rs.close();//�ر�ResultSet����
				stmt.close();//�ر�Statement����
				con.close();//�ر�Connection����
			%>

</CENTER>
<div class="href">
    <button class="btn btn-danger"><a id="inquire-href" href="inquire.html"><span>��һ����</span></a></button>
    <button class="btn btn-danger"><a id="index-href" href="../index.html"><span>�ص���ҳ</span></a></button>
</div>
</BODY>
</HTML>


