package org.example.NBAPlayer;

import java.util.*;


/**
*  @Description     数据库操作
*  @author          孙豪
*  @version         版本
*  @Date            2020年7月2日下午9:33:13
*/
public class NBADao 
{
	JDBCUtil jdbc = new JDBCUtil();
	//查询全部球员信息
	public List<List<Object>> queryAllPlayer()
	{
		List<List<Object>> query = jdbc.query("select * from NBAPlayer", null);
		return query;
	}
	//查询全部用户信息
	public List<List<Object>> queryAllUser()
	{
		List<List<Object>> query = jdbc.query("select * from 用户表（登录）", null);
		return query;
	}
	//根据最高分查看
	public List<List<Object>> queryHighest()
	{
		return jdbc.query("select * from NBAPlayer order by Highest desc", null);
	}
	//根据场均得分查看
	public List<List<Object>> queryAgera()
	{
		return jdbc.query("select * from NBAPlayer order by averaged desc", null);
	}
	//根据身高
	public List<List<Object>> queryHigh(int select)
	{
		if(select == 1)
		{
			return jdbc.query("select * from NBAPlayer order by height desc", null);
		}
		else if(select == 2)
		{
			return jdbc.query("select * from NBAPlayer order by height asc", null);
		}
		return null;
		
	}
	//根据体重查看
	public List<List<Object>> queryWeigh(int select)
	{
		if(select == 1)
		{
			return jdbc.query("select * from NBAPlayer order by weight desc", null);
		}
		else if(select == 2)
		{
			return jdbc.query("select * from NBAPlayer order by weight asc", null);
		}
		return null;
		
	}
	//根据编号查询
	public List<List<Object>> queryAByID(int id)
	{
		List<Object> list = new ArrayList<Object>();
		list.add(id);
		return jdbc.query("select * from NBAPlayer where id = ?", list);
	}
	//借球衣
	public int borrow(int id,String name)
	{
		List<Object> list = new ArrayList<Object>();
		list.add(name);
		list.add(id);
		return jdbc.update("update NBAPlayer set Jersey = 1,People = ? where id = ?", list);
	}
	//归还球衣
	public int returnNBA(int id)
	{
		List<Object> list = new ArrayList<Object>();
		list.add(id);
		return jdbc.update("update NBAPlayer set Jersey = 0,People = '' where id = ?", list);
	}
	//修改球员信息
	public int ModNBA(String name1,String name2,int num,String team,String select,String site,Double height,Double weight,Double aver,int high,String act,int id)
	{
		List<Object> list = new ArrayList<Object>();
		list.add(name1);
		list.add(name2);
		list.add(num);
		list.add(team);
		list.add(select);
		list.add(site);
		list.add(height);
		list.add(weight);
		list.add(aver);
		list.add(high);
		list.add(act);
		list.add(id);
		return jdbc.update("update NBAPlayer set ChineseName = ?,EnglishName = ?,num = ?,team = ?,IsFirst = ?,site = ?,height = ?,weight = ?,averaged = ?,Highest = ?,IsActive = ? where id = ?", list);
	}
	//新增球员
	public int AddNBA(String name1,String name2,int num,String team,String select,String site,Double height,Double weight,Double aver,int high,String act)
	{
		List<Object> list = new ArrayList<Object>();
		list.add(name1);
		list.add(name2);
		list.add(num);
		list.add(team);
		list.add(select);
		list.add(site);
		list.add(height);
		list.add(weight);
		list.add(aver);
		list.add(high);
		list.add(act);
		
		return jdbc.update("insert into NBAPlayer values(null,?,?,?,?,?,?,?,?,?,?,?,0,'')", list);
	}
	//新增用户
	public int AddUser(String name,String password,int role)
	{
		List<Object> list = new ArrayList<Object>();
		list.add(name);
		list.add(password);
		list.add(role);
		return jdbc.update("insert into 用户表（登录） values(null,?,?,?)", list);
	}
	//删除球员
	public int DeleteNBA(int id)
	{
		List<Object> list = new ArrayList<Object>();
		list.add(id);
		return jdbc.update("delete from NBAPlayer where id = ?", list);
	}
	//删除用户
	public int DeleteUser(String name,String password)
	{
		List<Object> list = new ArrayList<Object>();
		list.add(name);
		list.add(password);
		return jdbc.update("delete from 用户表（登录） where user = ? and password = ?", list);
	}
}
