package com.kevin.javabaselib.instance.designpattern.composite;
/**
 * @author 白良锦 bailiangjin@gmail.com
 *
 * @version 创建时间：2015年7月28日 上午11:36:29 
 *
 */
public class Programmer extends Employer {
    public Programmer(String name) {
        setName(name);
        employers = null;//程序员, 表示没有下属了
    }
    public void add(Employer employer) {
        
    }
    public void delete(Employer employer) {
        
    }
}
