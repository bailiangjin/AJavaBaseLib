package com.kevin.javabaselib.utils;

/**
 * App版本检测工具类
 * 
 * @author blj
 * 
 */
public class AppVersionCheckUtils
{

	/**
	 * 判断是否为最新版本
	 * 
	 * @param localVersion
	 *            本地版本号
	 * @param onlineVersion
	 *            线上版本号
	 */
	public static boolean isNewVersionDouble(String localVersion, String onlineVersion)
	{
		if (localVersion == null || onlineVersion == null)
		{
			return false;
		}

		return parseStrVersionCodeToDouble(onlineVersion).compareTo(parseStrVersionCodeToDouble(localVersion)) > 0 ? true
				: false;
	}

	/**
	 * 将字符串型版本号转换为Double型版本号
	 * 
	 * @param versionCode
	 * @return
	 */
	private static Double parseStrVersionCodeToDouble(String versionCode)
	{
		if (versionCode.contains("."))
		{
			String versionStr = versionCode.substring(0, versionCode.indexOf(".") + 1)
					+ versionCode.substring(versionCode.indexOf(".") + 1).replace(".", "");
			return Double.valueOf(versionStr);
		}
		else
		{
			return Double.valueOf(versionCode);
		}
	}

	/**
	 * String.comparTo方法
	 * 
	 * @param localVersion
	 * @param onlineVersion
	 * @return
	 */
	public static boolean isNewVersionStr(String localVersion, String onlineVersion)
	{
		if (localVersion == null || onlineVersion == null)
		{
			return false;
		}
		return onlineVersion.compareTo(localVersion) > 0 ? true : false;

	}

	/**
	 * 判断是否为最新版本方法 将版本号根据.切分为int数组 比较
	 * 
	 * @param localVersion
	 *            本地版本号
	 * @param onlineVersion
	 *            线上版本号
	 * @return
	 */
	public static boolean isAppNewVersion(String localVersion, String onlineVersion)
	{
		if (localVersion.equals(onlineVersion))
		{
			return false;
		}
		String[] localArray = localVersion.split("\\.");
		String[] onlineArray = onlineVersion.split("\\.");

		int length = localArray.length < onlineArray.length ? localArray.length : onlineArray.length;

		for (int i = 0; i < length; i++)
		{
			if (Integer.parseInt(onlineArray[i]) > Integer.parseInt(localArray[i]))
			{
				return true;
			}
			else if (Integer.parseInt(onlineArray[i]) < Integer.parseInt(localArray[i]))
			{
				return false;
			}
			// 相等 比较下一组值
		}

		return true;
	}

}
