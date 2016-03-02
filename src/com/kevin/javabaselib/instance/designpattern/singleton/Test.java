package com.kevin.javabaselib.instance.designpattern.singleton;




/**
 * @author 白良锦 bailiangjin@gmail.com
 *
 * @version 创建时间：2015年7月28日 上午10:12:03 
 *
 */
public class Test
{
	
	public static void main(String[] args)
	{
		Singleton sing = Singleton.getInstance();
        Singleton sing2 = Singleton.getInstance();
        
        System.out.println(sing);
        System.out.println(sing2);

	}

}
