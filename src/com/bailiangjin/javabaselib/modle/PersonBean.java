package com.bailiangjin.javabaselib.modle;

public class PersonBean
{
	private int id;
	private String name;
	public int age;
	public final int id1 = 1;

	
	public int getId1()
	{ 
		return id1;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getAge()
	{
		return age;
	}

	public void setAge(int age)
	{
		this.age = age;
	}

	@Override
	public String toString()
	{
		return "PersonBean [id=" + id + ", name=" + name + ", age=" + age + ", id1=" + id1 + "]";
	}
	
	

}
