package com.kevin.javabaselib.instance.designpattern.abstractfactory;
/**
 * @author 白良锦 bailiangjin@gmail.com
 *
 * @version 创建时间：2015年7月28日 下午3:11:50 
 *
 */
public interface IAnimalFactory {
    ICat createCat();
	
    IDog createDog();
}
