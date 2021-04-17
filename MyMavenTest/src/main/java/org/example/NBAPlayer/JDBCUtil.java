package org.example.NBAPlayer;

import java.sql.*;
import java.util.*;

/**
*  @Description     JDBD类——增删改、查
*  @author          孙豪
*  @version         版本
*  @Date            2020年7月2日下午9:25:29
*/
public class JDBCUtil 
{
	public int update(String sql,List<Object> list) {
		try {
			//1、加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			//2、获取连接
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/homework","root","sunhao2268411762");
			//3、预执行
			PreparedStatement ps = conn.prepareStatement(sql);
			if(list!=null) {
				//说明该语句中有问号
				for(int i =0;i<list.size();i++) {
					ps.setObject(i+1,list.get(i));
				}
			}
			//执行
			int row = ps.executeUpdate();
			//释放内存
			ps.close();
			conn.close();
			//返回值
			return row;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	//查的封装（用于显示NBA球员的所有信息）
	public List<List<Object>> query(String sql,List<Object> list) {
		try {
			//1、加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			//2、获取连接
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/homework","root","sunhao2268411762");
			//3、预执行
			PreparedStatement ps = conn.prepareStatement(sql);
			if(list!=null) {
				//说明有句号
				for(int i =0;i<list.size();i++) {
					ps.setObject(i+1,list.get(i));
				}
			}
			//4、执行
			ResultSet ret = ps.executeQuery();
			//定义二维数组，一张表格
			List<List<Object>> table = new ArrayList<List<Object>>();
			while(ret.next()) {//执行次数为行数
				//定义一维数组，一行
				List<Object> row = new ArrayList<Object>();
				//获取结果集中列的个数
				int columnCount = ret.getMetaData().getColumnCount();
				//将一行填充完成
				for(int i = 1;i<= columnCount;i++) {//执行次数为列数
					row.add(ret.getObject(i));
				}
				//将当前行放入表格
				table.add(row);
			}
			//5、释放
			ret.close();
			ps.close();
			conn.close();
			//返回值
			return table;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
