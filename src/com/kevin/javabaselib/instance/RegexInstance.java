package com.kevin.javabaselib.instance;


public class RegexInstance
{
	public static void main(String[] args)
	{
		regextest();
	}

	public static void regextest()
	{
		String str = "我我...我我...我要..要要...学学学....学学...编编编...程.程程...程....城";
		str = str.replaceAll("\\.+", "");
		System.out.println(str);
		System.out.println(str.replaceAll("([我要学编程])\\1+", "$1"));

		// String str = "198.12.5.11 2.0.222.123 135.2.222.32 20.21.09.2";
		// str = str.replaceAll("(\\d+)", "00$1");
		// System.out.println(str);
		// str = str.replaceAll("0*(\\d{3})", "$1");
		// System.out.println(str);
		// TreeSet<String> hs = new TreeSet<String>();
		// String[] str1 = str.split(" ");
		// for (String s : str1)
		// {
		// hs.add(s);
		// }
		// for (String s : hs)
		// {
		// System.out.println(s);
		// }
	}

	// public static boolean checkEmailValid_bak(String strEmail)
	// {
	// if (strEmail == null)
	// {
	// return false;
	// }
	// String check =
	// "^[a-zA-Z][\\w\\.-]*[a-zA-Z0-9]@[a-zA-Z0-9][\\w\\.-]*[a-zA-Z0-9]\\.[a-zA-Z][a-zA-Z\\.]*[a-zA-Z]$";
	// Pattern regex = Pattern.compile(check);
	// Matcher matcher = regex.matcher(strEmail);
	// boolean isMatched = matcher.matches();
	// return isMatched;
	//
	// }

}
