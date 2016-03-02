package com.kevin.javabaselib.instance.designpattern.adapter;
/**
 * @author 白良锦 bailiangjin@gmail.com
 *
 * @version 创建时间：2015年7月28日 下午1:22:14 
 *
 */
public class Adapter implements Target {
    private Adaptee adaptee;
    
    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }
	public void adapteeMethod() {
	adaptee.adapteeMethod();
	}
	public void adapterMethod() {
	System.out.println("Adapter method!");
    }
}
