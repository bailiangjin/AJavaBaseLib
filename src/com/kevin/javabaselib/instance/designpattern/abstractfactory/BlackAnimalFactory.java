package com.kevin.javabaselib.instance.designpattern.abstractfactory;
/**
 * @author 白良锦 bailiangjin@gmail.com
 *
 * @version 创建时间：2015年7月28日 下午3:16:56 
 *
 */
public class BlackAnimalFactory implements IAnimalFactory {
    public ICat createCat() {
        return new BlackCat();
    }
    public IDog createDog() {
        return new BlackDog();
    }
}

