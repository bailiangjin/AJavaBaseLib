package com.kevin.javabaselib.instance.designpattern.builder;


/**
 * @author 白良锦 bailiangjin@gmail.com
 *
 * @version 创建时间：2015年7月28日 上午11:16:20 
 *
 */
public class ManBuilder implements PersonBuilder {
    Person person;
    
    public ManBuilder() {
        person = new Man();
    }
    
    public void buildBody() {
        person.setBody("建造男人的身体");
    }
    public void buildFoot() {
        person.setFoot("建造男人的脚");
    }
    public void buildHead() {
        person.setHead("建造男人的头");
    }
    public Person buildPerson() {
        return person;
    }

}