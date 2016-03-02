package com.kevin.javabaselib.instance.designpattern.composite;

import java.util.List;

/**
 * @author 白良锦 bailiangjin@gmail.com
 *
 * @version 创建时间：2015年7月28日 上午11:35:36 
 *
 */
public abstract class Employer {
    private String name;
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return this.name;
    }
    
    public abstract void add(Employer employer);
    
    public abstract void delete(Employer employer);
    
    public List employers;
    
    public void printInfo() {
        System.out.println(name);
    }
    
    public List getEmployers() {
        return this.employers;
    }
}
