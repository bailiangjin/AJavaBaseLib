package com.kevin.javabaselib.instance.blog;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * 动态删除 List 特征元素 示例
 * 
 * @author blj
 * 
 */
public class RemoveFromListDemo
{

	static class Bean
	{

		private String name;

		public String getName()
		{
			return name;
		}

		public void setName(String name)
		{
			this.name = name;
		}

	}

	/**
	 * 动态删除List元素示例
	 */
	public static void dynamicRemoveItemFromListDemo()
	{

		List<Bean> list = getList();

		System.out.println("原始数据：");
		printList(list);

		// 使用普通for循环遍历List删除自身元素 不报错 但结果 未必正确
		normalRemoveMethod(list);

		// 使用高级for循环遍历List删除自身元素 报错
		// try
		// {
		// superRemoveMethod(list);
		// }
		// catch (Exception e)
		// {
		// System.err.println("高级for循环报错：");
		// e.printStackTrace();
		// }

		// 引入参考List 遍历删除方法
		// referenceRemoveMethod(list);

		// iterator遍历删除方法
		// iteratorRemoveMethod(list);

		System.out.println("结果数据：");
		printList(list);

	}

	/**
	 * 打印 List 方法
	 * 
	 * @param list
	 */
	private static void printList(List<Bean> list)
	{
		for (Bean item : list)
		{
			System.out.print(item.getName() + " ");
		}
		System.out.println();
	}

	/**
	 * 利用普通for循环遍历删除元素（不会报异常 但结果未必正确）
	 * 
	 * @param list
	 */
	private static void normalRemoveMethod(List<Bean> list)
	{
		for (int i = 0; i < list.size(); i++)
		{
			if (list.get(i).getName().equals("A"))
			{
				list.remove(list.get(i));
			}
		}
	}

	/**
	 * 利用高级for循环遍历删除元素（会报异常）
	 * 
	 * @param list
	 */
	private static void superRemoveMethod(List<Bean> list)
	{
		for (Bean item : list)
		{
			if (item.getName().equals("A"))
			{
				list.remove(item);
			}
		}
	}

	/**
	 * 有效的for循环遍历删除元素（正常 达到预期目的）
	 * 
	 * @param list
	 */
	private static void referenceRemoveMethod(List<Bean> list)
	{
		List<Bean> referenceList = new ArrayList<Bean>();
		referenceList.addAll(list);

		for (int i = 0; i < referenceList.size(); i++)
		{
			if (referenceList.get(i).getName().equals("A"))
			{
				list.remove(referenceList.get(i));
			}
		}
	}

	/**
	 * 使用Iterator的方式也可以顺利删除和遍历
	 */
	public static void iteratorRemoveMethod(List<Bean> list)
	{
		Iterator<Bean> it = list.iterator();
		while (it.hasNext())
		{
			Bean student = it.next();
			if (student.getName().equals("A"))
				it.remove();
		}
	}

	/**
	 * 获取List方法
	 * 
	 * @return
	 */
	private static List<Bean> getList()
	{
		List<Bean> list = new ArrayList<Bean>();

		for (int i = 0; i < 50; i++)
		{
			Bean item = new Bean();
			int j = i + new Random().nextInt();
			if (j % 3 == 1)
			{
				item.setName("A");
			}
			else if (j % 3 == 2)
			{
				item.setName("B");
			}
			else
			{
				item.setName("C");
			}

			list.add(item);
		}
		return list;
	}

}
