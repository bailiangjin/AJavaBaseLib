package com.kevin.javabaselib.enums;

/**
 * 使用接口组织枚举
 * 
 * @author blj
 * 
 */
public interface EnumInterFace
{
	enum Coffee implements EnumInterFace
	{
		BLACK_COFFEE, DECAF_COFFEE, LATTE, CAPPUCCINO
	}

	enum Dessert implements EnumInterFace
	{
		FRUIT, CAKE, GELATO
	}

}
