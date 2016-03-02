package com.kevin.javabaselib;

import com.kevin.javabaselib.instance.GsonTestDemo;

public class TestMain
{
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// String gmail = "3b32cdfe@sin1a0000000.com.com.cm";
		//
		// System.out.println(isEmailFormat(gmail));
		// String number = "010-20332058-0000";
		// System.out.println(FormatCheckUtils.checkPhoneNumberValid(number));
		// String mobile = "11630016890";
		// System.out.println(ValidateUtils.checkMobileNumberValid(mobile));
		// regextest();

		GsonTestDemo.testGson();

		long sum = 0;
		long fac = 1;
		for (int i = 1; i <= 20; i++)
		{
			fac = fac * i;
			System.out.println(fac);
			sum += fac;
		}
		System.out.println(sum);
		System.out.println("-200".equals(null));

	}

}
