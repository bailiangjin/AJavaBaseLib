package com.kevin.javabaselib.instance;

/**
 * java 面试宝典2014 编程题 不完善
 * 
 * @author blj
 * 
 */
public class RenMinBi
{

	/**
	 * @param args
	 *            add by zxx ,Nov 29, 2008
	 */
	private static final char[] data = new char[] { '零', '壹', '贰', '叁', '肆', '伍', '陆', '柒', '捌', '玖' };
	private static final char[] units = new char[] { '元', '拾', '佰', '仟', '万', '拾', '佰', '仟', '亿' };

	public static void main(String[] args)
	{ // TODOAuto-generated method stub
		System.out.println(convert(135689123));
		System.out.println(convert(100000123));
	}

	public static String convert(int money)
	{
		StringBuffer sbf = new StringBuffer();
		int unit = 0;
		while (money != 0)
		{
			sbf.insert(0, units[unit++]);
			int number = money % 10;
			sbf.insert(0, data[number]);
			money /= 10;
		}
		return sbf.toString().replaceAll("零[拾佰仟]", "零").replaceAll("零+万", "万").replaceAll("零+元", "元")
				.replaceAll("零+", "零");
		// return sbf.toString();
	}
}