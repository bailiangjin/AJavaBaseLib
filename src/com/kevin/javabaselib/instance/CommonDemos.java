package com.kevin.javabaselib.instance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommonDemos
{

	/**
	 * 计算公交费用
	 * 
	 * @param orgCoast
	 *            初始话费
	 * @return 折价后费用
	 */
	public static double countCoast(double orgCoast)
	{
		if (orgCoast <= 100)
		{
			return orgCoast;
		}
		else if (100 < orgCoast && orgCoast <= 150)
		{
			return 100 + (orgCoast - 100) * 0.8;
		}
		else if (150 < orgCoast && orgCoast <= 400)
		{
			return 100 + 50 * 0.8 + (orgCoast - 150) * 0.5;
		}
		else
		{
			return orgCoast;
		}
	}

	/**
	 * 解析高法 应用请求
	 * 
	 * @param data
	 * @return
	 */
	public static List<String> parseAppAction(String data)
	{
		List<String> list = new ArrayList<String>();

		String action = data.substring(0, data.indexOf("?"));
		System.out.println("action:" + action);
		list.add(action);
		String exraData = data.substring(data.indexOf("?") + 1, data.length());
		System.out.println("extraData:" + exraData);
		String[] extras = exraData.split("&");
		Map<String, String> map = new HashMap<String, String>();
		for (String string : extras)
		{
			// System.out.println("extra:" + string);
			// String[] dataMap = string.split("=");
			// map.put(dataMap[0], dataMap[1]);
			list.add(string);
		}
		return list;

	}

	/**
	 * 动态添加元素到list中Demo
	 */
	public static void dynamicAddElementToListDemo()
	{
		List<String> list1 = new ArrayList<String>();

		for (int i = 0; i < 10; i++)
		{
			if (i <= 3)
			{
				String a = "a";
				list1.add(a);
			}
			else if (i <= 6)
			{
				String a = "b";
				list1.add(a);
			}
			else
			{
				String a = "c";
				list1.add(a);
			}
		}
		String last = "-1";
		List<String> list2 = new ArrayList<>();
		list2.addAll(list1);
		int index = 1;
		for (int i = 0; i < list1.size(); i++)
		{
			if (!list1.get(i).equals(last))
			{
				list2.add(i + index - 1, String.valueOf(index++));
			}
			last = list1.get(i);
		}

		for (String string : list1)
		{
			System.out.println(string);
		}
		for (String string : list2)
		{
			System.out.println(string);
		}

	}
}
