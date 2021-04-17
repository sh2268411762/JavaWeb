package org.example.NBAPlayer;

import java.util.ArrayList;
import java.util.List;


/**
*  @Description     登录
*  @author          孙豪
*  @version         版本
*  @Date            2020年7月2日下午9:32:13
*/
@SuppressWarnings("unused")
//实现用户登录
public class DAONba 
{
	//login中定义两个变量即用户名和登录密码
	public List<List<Object>> login(String name,String password)
	{
		JDBCUtil jdbc = new JDBCUtil();
		List<Object> list = new ArrayList<Object>();
		list.add(name);//用户名
		list.add(password);//密码
		List<List<Object>> query = jdbc.query("select * from 用户表（登录） where user = ? and password =?", list);
		//返回查询的二维数组
		return query;
	}
}
