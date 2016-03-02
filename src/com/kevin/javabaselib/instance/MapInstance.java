package com.kevin.javabaselib.instance;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class MapInstance
{

	public static void main(String[] args)
	{

		String str = "abcacbdseghadfxcd";
		char[] charArray = str.toCharArray();

		Map<Character, Integer> map = new HashMap<Character, Integer>();

		for (int i = 0; i < charArray.length; i++)
		{
			char c = charArray[i];
			if (map.containsKey(c))
			{
				map.put(c, map.get(c) + 1);
			}
			else
			{
				map.put(c, 1);
			}
		}

		int maxTimes = 0;
		Character result = null;
		for (Entry<Character, Integer> entry : map.entrySet())
		{
			if (entry.getValue() > maxTimes)
			{
				maxTimes = entry.getValue();
				result = entry.getKey();
			}
		}

		System.out.println("出现次数最多的是：" + result + " " + maxTimes + "次");

	}

}
