package com.kevin.javabaselib.instance.designpattern.builder;
/**
 * @author 白良锦 bailiangjin@gmail.com
 *
 * @version 创建时间：2015年7月28日 上午11:13:13 
 *
 */
public interface PersonBuilder {
    void buildHead();
    
    void buildBody();
    
    void buildFoot();
    Person buildPerson();
}
