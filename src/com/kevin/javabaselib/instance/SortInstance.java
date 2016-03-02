package com.kevin.javabaselib.instance;

public class SortInstance
{
	public static void main(String[] args)
	{
		int[] a1 = { 1, 3, 5, 7, 9 };
		int[] a2 = { 2, 3, 4, 5, 6, 8 };

		int[] result = MergeList(a1, a2);

		for (Integer integer : result)
		{
			System.out.print(integer + " ");
		}
	}

	public static int[] MergeList(int a[], int b[])
	{
		int result[];
		// if (checkSort(a) && checkSort(b))
		// { // 检查传入的数组是否是有序的
		result = new int[a.length + b.length];
		int i = 0, j = 0, k = 0; // i:用于标示a数组 j：用来标示b数组 k：用来标示传入的数组

		while (i < a.length && j < b.length)
		{
			if (a[i] <= b[j])
			{
				result[k++] = a[i++];
			}
			else
			{
				result[k++] = b[j++];
			}
		}

		while (i < a.length)
		{
			result[k++] = a[i++];
		}
		while (j < b.length)
		{
			result[k++] = b[j++];
		}

		// }

		return result;

	}

}
