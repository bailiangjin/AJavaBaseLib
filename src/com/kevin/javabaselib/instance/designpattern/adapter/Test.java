package com.kevin.javabaselib.instance.designpattern.adapter;
/**
 * @author 白良锦 bailiangjin@gmail.com
 *
 * @version 创建时间：2015年7月28日 下午1:23:02 
 *
 */
public class Test {
    public static void main(String[] args) {
        Target target = new Adapter(new Adaptee());
        target.adapteeMethod();
        
        target.adapterMethod();
    }
}
