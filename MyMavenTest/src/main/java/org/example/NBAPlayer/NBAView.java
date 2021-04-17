package org.example.NBAPlayer;

import java.util.*;

/**
*  @Description     球员操作
*  @author          孙豪
*  @version         版本
*  @Date            2020年7月2日下午9:30:31
*/
@SuppressWarnings("unused")
public class NBAView 
{
	public static void menu()
	{
		System.out.println("普通用户：");
		System.out.println("1、显示所有球员信息");
		System.out.println("2、按最高得分查看球员信息");
		System.out.println("3、按场均得分查看球员信息");
		System.out.println("4、借球员球衣");
		System.out.println("5、还球员球衣");
		System.out.println("6、按身高查看球员信息");
		System.out.println("7、按体重查看球员信息");
		System.out.println("0、退出");
		System.out.println("请输入【0-7】");
	}

	Scanner sc = new Scanner(System.in);
	NBADao d = new NBADao();
	public void CommonMenu()//普通用户菜单
	{
		menu();
		int input = sc.nextInt();//选择输入
		
		do {
			switch(input)
			{
			case 1:
				System.out.println("开始显示：");
				showallPlayer();
				System.out.println("显示完成！");
				break;
				
			case 2:
				System.out.println("开始显示：");
				showHighest();
				System.out.println("显示完成！");
				break;
				
			case 3:
				System.out.println("开始显示：");
				showAger();
				System.out.println("显示完成！");
				break;
				
			case 4:
				System.out.println("开始借球衣：");
				BorrowNba();
				System.out.println("借球衣完成！");
				break;
				
			case 5:
				System.out.println("开始归还球衣：");
				ReturnNba();
				System.out.println("归还球衣完成：");
				break;
				
			case 6:
				System.out.println("开始显示：");
				showHigh();
				System.out.println("显示完成！");
				break;
				
			case 7:
				System.out.println("开始显示：");
				showWeigh();
				System.out.println("显示完成！");
				break;
				
			case 0:
				System.out.println("程序退出！！！");
				break;
			default :
				System.out.println("输入有误，请重新输入！！！");
				break;
			}
			if(input != 0)
			{
				System.out.println();
				menu();
				input = sc.nextInt();
			}
		}while(input != 0);
		System.out.println("欢迎下次再来！");
	}
	//显示全部
	public void showallPlayer()//打印全部球员信息
	{
		List<List<Object>> list = d.queryAllPlayer();
		if(list == null || list.size() == 0)
		{
			System.out.println("没有查询到数据！！！");
		}
		else
		{
			System.out.println("编号\t姓名\t英文名\t号码\t球队\t是否首发\t位置\t身高\t体重\t场均得分\t最高得分\t是否现役\t是否借出\t出借人");
			for(int i = 0;i < list.size();i++)
			{
				for(int j = 0;j < list.get(i).size();j++)
				{
					System.out.print(list.get(i).get(j) + "\t");
				}
				System.out.println();
			}
		}
	}
	//按最高分显示
	public void showHighest()
	{
		List<List<Object>> list = d.queryHighest();
		if(list == null || list.size() == 0)
		{
			System.out.println("没有查询到数据！！！");
		}
		else
		{
			System.out.println("编号\t姓名\t英文名\t号码\t球队\t是否首发\t位置\t身高\t体重\t场均得分\t最高得分\t是否现役\t是否借出\t出借人");
			for(int i = 0;i < list.size();i++)
			{
				for(int j = 0;j < list.get(i).size();j++)
				{
					System.out.print(list.get(i).get(j) + "\t");
				}
				System.out.println();
			}
		}
	}
	//按场均得分显示
	public void showAger()
	{
		List<List<Object>> list = d.queryAgera();
		if(list == null || list.size() == 0)
		{
			System.out.println("没有查询到数据！！！");
		}
		else
		{
			System.out.println("编号\t姓名\t英文名\t号码\t球队\t是否首发\t位置\t身高\t体重\t场均得分\t最高得分\t是否现役\t是否借出\t出借人");
			for(int i = 0;i < list.size();i++)
			{
				for(int j = 0;j < list.get(i).size();j++)
				{
					System.out.print(list.get(i).get(j) + "\t");
				}
				System.out.println();
			}
		}
	}
	//身高
	public void showHigh()
	{
		System.out.println("1、降序\n2、升序");
		System.out.println("请选择【1-2】");
		int select = sc.nextInt();
		List<List<Object>> list = d.queryHigh(select);
		if(list == null || list.size() == 0)
		{
			System.out.println("输入有误，退出显示！！！");
		}
		else
		{
			System.out.println("编号\t姓名\t英文名\t号码\t球队\t是否首发\t位置\t身高\t体重\t场均得分\t最高得分\t是否现役\t是否借出\t出借人");
			for(int i = 0;i < list.size();i++)
			{
				for(int j = 0;j < list.get(i).size();j++)
				{
					System.out.print(list.get(i).get(j) + "\t");
				}
				System.out.println();
			}
		}
	}
	//按体重显示
	public void showWeigh()
	{
		System.out.println("1、降序\n2、升序");
		System.out.println("请选择【1-2】");
		int select = sc.nextInt();
		List<List<Object>> list = d.queryWeigh(select);
		if(list == null || list.size() == 0)
		{
			System.out.println("输入有误，退出显示！！！");
		}
		else
		{
			System.out.println("编号\t姓名\t英文名\t号码\t球队\t是否首发\t位置\t身高\t体重\t场均得分\t最高得分\t是否现役\t是否借出\t出借人");
			for(int i = 0;i < list.size();i++)
			{
				for(int j = 0;j < list.get(i).size();j++)
				{
					System.out.print(list.get(i).get(j) + "\t");
				}
				System.out.println();
			}
		}
	}
	//借出球衣
	public void BorrowNba()
	{
		System.out.println("请输入要借的球员编号：");
		int id = sc.nextInt();
		List<List<Object>> list = d.queryAByID(id);
		if(list == null || list.size() == 0)
		{
			System.out.println("没有编号为" + id + "的球衣");
		}
		else
		{
			if((int)(list.get(0).get(12)) == 1)
			{
				System.out.println("编号为" + id + "的球衣已被借出");
			}
			else
			{
				System.out.println("请输入球迷姓名：");
				String name = sc.next();
				
				int row = d.borrow(id, name);
				if(row == 0)
				{
					System.out.println("出借失败！");
				}
				else
				{
					System.out.println("出借成功！");
				}
			}
		}
	}
	//归还球衣
	public void ReturnNba()
	{
		System.out.println("请输入要归还的球衣编号:");
		int id = sc.nextInt();
		List<List<Object>> list = d.queryAByID(id);
		if(list == null || list.size() == 0)
		{
			System.out.println("没有编号为" + id + "的球衣");
		}
		else
		{
			if((int)(list.get(0).get(12)) == 0)
			{
				System.out.println("编号为" + id + "的球衣没有被借出！");
			}
			else
			{
				int row = d.returnNBA(id);
				if(row == 0)
				{
					System.out.println("归还失败！");
				}
				else
				{
					System.out.println("归还成功！");
				}
			}
		}
	}
	
	
	//管理员菜单
	public void menu1()
	{
		System.out.println("管理员用户：");
		System.out.println("1、显示所有球员");
		System.out.println("2、新增球员");
		System.out.println("3、删除球员");
		System.out.println("4、按最高得分查看球员信息");
		System.out.println("5、按场均得分查看球员信息");
		System.out.println("6、按身高查看球员信息");
		System.out.println("7、按体重查看球员信息");
		System.out.println("8、修改球员信息");
		System.out.println("9、新增用户");
		System.out.println("10、删除用户");
		System.out.println("11、查看用户");
		System.out.println("0、退出");
		System.out.println("请输入【0-11】");
	}
	@SuppressWarnings("resource")
	public void ManaMenu()
	{
		menu1();
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		
		do {
			switch(input)
			{
			case 1:
				System.out.println("开始显示：");
				showallPlayer();
				System.out.println("显示完成！");
				break;
				
			case 2:
				System.out.println("开始新增：");
				AddPlayer();
				System.out.println("新增完成！");
				break;
				
			case 3:
				System.out.println("开始删除：");
				DeletePlayer();
				System.out.println("删除完成！");
				break;
				
			case 4:
				System.out.println("开始显示：");
				showHighest();
				System.out.println("显示完成！");
				break;
				
			case 5:
				System.out.println("开始显示：");
				showAger();
				System.out.println("显示完成！");
				break;
				
			case 6:
				System.out.println("开始显示：");
				showHigh();
				System.out.println("显示完成！");
				break;
				
			case 7:
				System.out.println("开始显示：");
				showWeigh();
				System.out.println("显示完成！");
				break;
				
			case 8:
				System.out.println("开始修改：");
				modifyNba();
				System.out.println("修改完成！");
				break;
				
			case 9:
				System.out.println("新增用户：");
				AddUser();
				System.out.println("新增完成！");
				break;
				
			case 10:
				System.out.println("删除用户：");
				DeleteUser();
				System.out.println("删除完成！");
				break;
				
			case 11:
				System.out.println("开始显示：");
				showUser();
				System.out.println("显示完成！");
				break;
			case 0:
				System.out.println("程序退出！！！");
				break;
			default :
				System.out.println("输入有误，请重新输入！！！");
				break;
			}
			if(input != 0)
			{
				System.out.println();
				menu1();
				input = sc.nextInt();
			}
		}while(input != 0);
		System.out.println("欢迎下次再来！");
	}
	
	//显示所有用户
	public void showUser()
	{
		List<List<Object>> list = d.queryAllUser();
		if(list == null || list.size() == 0)
		{
			System.out.println("没有查询到数据！！！");
		}
		else
		{
			System.out.println("编号\t用户名\t密码\t是否管理员");
			for(int i = 0;i < list.size();i++)
			{
				for(int j = 0;j < list.get(i).size();j++)
				{
					System.out.print(list.get(i).get(j) + "\t");
				}
				System.out.println();
			}
		}
	}
	//添加用户
	public void AddUser()
	{
		System.out.println("请输入要新增的用户名：");
		String name = sc.next();
		System.out.println("请输入用户" + name + "的密码：");
		String password = sc.next();
		System.out.println("用户" + name + "是否为管理员（1或0）：");
		int role = sc.nextInt();
		
		int row = d.AddUser(name,password,role);
	}
	//删除用户
	public void DeleteUser()
	{
		System.out.println("请输入要删除的用户名：");
		String name = sc.next();
		System.out.println("请输入用户" + name +"的密码：");
		String password = sc.next();
		
		int row = d.DeleteUser(name,password);
		if(row == 0)
		{
			System.out.println("删除失败！");
		}
		else
		{
			System.out.println("已删除用户名为" + name+ "的用户！");
		}
		
	}
	//修改球员信息
	public void modifyNba()
	{
		System.out.println("请输入要修改的球员编号：");
		int id = sc.nextInt();
		
		List<List<Object>> list = d.queryAByID(id);
		if(list == null || list.size() == 0)
		{
			System.out.println("没有编号为" + id + "的球员");
		}
		else
		{
			System.out.println("请输入要修改的球员名字：");
			String name1 = sc.next();
			System.out.println("请输入要修改的球员英文名字：");
			String name2 = sc.next();
			System.out.println("请输入球员" + name1 + "的球衣号码：");
			int num = sc.nextInt();
			System.out.println("请输入球员" + name1 + "的球队：");
			String team = sc.next();
			System.out.println("球员" + name1 + "是否为该球队首发（Y或N）：");
			String select = sc.next();
			System.out.println("球员" + name1 + "的位置是：");
			String site = sc.next();
			System.out.println("请输入球员" + name1 + "的身高：");
			Double height = sc.nextDouble();
			System.out.println("请输入球员" + name1 + "的体重：");
			Double weight = sc.nextDouble();
			System.out.println("请输入球员" + name1 + "的场均得分：");
			Double aver = sc.nextDouble();
			System.out.println("请输入球员" + name1 + "的单场最高得分：");
			int high = sc.nextInt();
			System.out.println("球员" + name1 + "是否为 现役球员（Y或N）：");
			String act = sc.next();
			
			int row = d.ModNBA(name1, name2, num,team,select,site,height,weight,aver,high,act,id);
			if(row == 0)
			{
				System.out.println("修改失败!");
			}
			else
			{
				System.out.println("修改球员为" + name1 + "球衣号码为" + num +"的" + team + "队员");
			}
		}
	}
	//新增球员
	public void AddPlayer()
	{
		System.out.println("请输入要新增的球员名字：");
		String name1 = sc.next();
		System.out.println("请输入要新增的球员英文名字：");
		String name2 = sc.next();
		System.out.println("请输入球员" + name1 + "的球衣号码：");
		int num = sc.nextInt();
		System.out.println("请输入球员" + name1 + "的球队：");
		String team = sc.next();
		System.out.println("球员" + name1 + "是否为该球队首发（Y或N）：");
		String select = sc.next();
		System.out.println("球员" + name1 + "的位置是：");
		String site = sc.next();
		System.out.println("请输入球员" + name1 + "的身高：");
		Double height = sc.nextDouble();
		System.out.println("请输入球员" + name1 + "的体重：");
		Double weight = sc.nextDouble();
		System.out.println("请输入球员" + name1 + "的场均得分：");
		Double aver = sc.nextDouble();
		System.out.println("请输入球员" + name1 + "的单场最高得分：");
		int high = sc.nextInt();
		System.out.println("球员" + name1 + "是否为 现役球员（Y或N）：");
		String act = sc.next();
		
		
		int row = d.AddNBA(name1, name2, num,team,select,site,height,weight,aver,high,act);
		if(row == 0)
		{
			System.out.println("新增失败!");
		}
		else
		{
			System.out.println("新增球员为" + name1 + "球衣号码为" + num +"的" + team + "队员");
		}
	}
	//删除球员
	public void DeletePlayer()
	{
		System.out.println("请输入要删除的球员编号：");
		int id = sc.nextInt();
		List<List<Object>> list = d.queryAByID(id);
		if(list == null || list.size() == 0)
		{
			System.out.println("没有编号为" + id + "的球员");
		}
		else
		{
			int row = d.DeleteNBA(id);
			if(row == 0)
			{
				System.out.println("删除失败！");
			}
			else
			{
				System.out.println("已删除ID为" + id + "的球员！");
			}
		}
	}
}
