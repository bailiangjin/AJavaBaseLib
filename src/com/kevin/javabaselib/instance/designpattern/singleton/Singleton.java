package com.kevin.javabaselib.instance.designpattern.singleton;


/**
 * 
 * @author 白良锦 bailiangjin@gmail.com
 *
 * @version 创建时间：2015年7月28日 上午10:04:23 
 *
 */
public class Singleton
{
	private static volatile Singleton instance = null;

	public static Singleton getInstance()
	{
		if (instance == null)
		{
			synchronized (Singleton.class)
			{
				if (instance == null)
				{
					instance = new Singleton();
				}
			}
		}
		return instance;
	}

	private Singleton()
	{

	}

	private Object readResolve()
	{
		return instance;
	}

}
