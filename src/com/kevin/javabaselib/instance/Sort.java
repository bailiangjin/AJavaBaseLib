package com.kevin.javabaselib.instance;

public class Sort
{

	public static void main(String[] args)
	{
		int[] array = { 1, 9, 8, 3, 5, 2, 3, 7, 4 };
//		quickSort(array, 0, array.length - 1);
		 bubbleSort(array);
		for (int i : array)
		{
			System.out.print(i + "\t");
		}

	}

	/**
	 * 快速排序
	 * 
	 * @param arr
	 *            数组
	 * @param low
	 *            低位
	 * @param high
	 *            高位
	 */
	public static void quickSort(int arr[], int low, int high)
	{
		int l = low;
		int h = high;
		int povit = arr[low];

		while (l < h)
		{
			while (l < h && arr[h] >= povit)
				h--;
			if (l < h)
			{
				int temp = arr[h];
				arr[h] = arr[l];
				arr[l] = temp;
				l++;
			}

			while (l < h && arr[l] <= povit)
				l++;
			if (l < h)
			{
				int temp = arr[h];
				arr[h] = arr[l];
				arr[l] = temp;
				h--;
			}
		}
		for (int i : arr)
		{
			System.out.print(i + "\t");
		}
		System.out.print("l=" + (l) + "h=" + (h) + "povit=" + povit + "\n");
		if (l > low)
			quickSort(arr, low, l - 1);
		if (h < high)
			quickSort(arr, l + 1, high);
	}

//	/**
//	 * 冒泡排序算法
//	 */
//	public static void bubbleSort(int[] values)
//	{
//		int temp;
//		for (int i = 0; i < values.length; ++i)
//		{
//			for (int j = 0; j < values.length - i - 1; ++j)
//			{
//				if (values[j] > values[j + 1])
//				{
//					temp = values[j];
//					values[j] = values[j + 1];
//					values[j + 1] = temp;
//				}
//			}
//		}
//	}

	/**
	 * 冒泡排序
	 * @param arr
	 */
	public static void bubbleSort(int[] arr)
	{
		int temp;
		for (int i = 0; i < arr.length; i++)
		{
			for (int j = 0; j < arr.length - 1 - i; j++)
			{
				if (arr[j] > arr[j + 1])
				{
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}
}
