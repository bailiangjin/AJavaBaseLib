package com.kevin.javabaselib.instance;

import java.util.List;

public class Algorithm
{

	public static void main(String[] args)
	{
		String[] ss=new String[16000000];

//		int value =1024;
//		System.out.println((value & value - 1)==0 ? true:false);
		// int[] array = { 1, 9, 8, 3, 5, 2, 3, 7, 4 };
		// quickSort(array, 0, array.length - 1);

		// 方法可以改变参数的值 但不会更改参数的引用
		// int left = 0;
		// int right = 1;
		// System.out.println("left=" + left + "right=" + right);
		// swap(left, right);
		// System.out.println("left=" + left + "right=" + right);

		// List<Integer> listLeft = new ArrayList<Integer>();
		// listLeft.add(1);
		// List<Integer> listRight = new ArrayList<Integer>();
		// listRight.add(2);
		//
		// System.out.println("left:");
		// for (Integer integer : listLeft)
		// {
		// System.out.print(integer + "\t");
		// }
		// System.out.println();
		// System.out.println("right:");
		// for (Integer integer : listRight)
		// {
		// System.out.print(integer + "\t");
		// }
	}

	public static void swap(int left, int right)
	{
		int temp;
		temp = left;
		left = right;
		right = temp;
	}

	public static void swap(List<Integer> left, List<Integer> right)
	{
		List<Integer> temp;
		left.add(11);
		right.add(22);
		temp = left;
		left = right;
		right = temp;
	}

	
}
