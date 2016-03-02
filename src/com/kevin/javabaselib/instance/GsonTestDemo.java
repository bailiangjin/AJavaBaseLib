package com.kevin.javabaselib.instance;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.google.gson.annotations.Since;

public class GsonTestDemo
{
	public static void testGson()
	{
		Gson gson = new Gson();
		// 使用暴露方式时 需要给所有需要生成在json字符串中的字段添加@Expose注解
		// Gson gson = new
		// GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		Person bean = new Person();
		bean.setId(1);
		bean.setAge(20);
		bean.setName("test");
//		bean.setHobby("play");
		String json = gson.toJson(bean);
		System.out.println(json);

		Person pb = gson.fromJson(json, Person.class);
		System.out.println(pb.getId());
		System.out.println(pb.getAge());
		System.out.println(pb.getName());
//		System.out.println(pb.getHobby());
		System.out.println(pb.getuId());
	}

	static class Person
	{
		private int id;
		private int age;
		@Expose
		private String name;
		//替换属性名
		@SerializedName("interest")
		private String hobby;
		@Since(1.0)
		private String uId;

		public int getId()
		{
			return id;
		}

		public void setId(int id)
		{
			this.id = id;
		}

		public int getAge()
		{
			return age;
		}

		public void setAge(int age)
		{
			this.age = age;
		}

		public String getName()
		{
			return name;
		}

		public void setName(String name)
		{
			this.name = name;
		}

		public String getuId()
		{
			return uId;
		}

		public void setuId(String uId)
		{
			this.uId = uId;
		}

		// public String getHobby()
		// {
		// return hobby;
		// }
		//
		// public void setHobby(String hobby)
		// {
		// this.hobby = hobby;
		// }

	}

}
