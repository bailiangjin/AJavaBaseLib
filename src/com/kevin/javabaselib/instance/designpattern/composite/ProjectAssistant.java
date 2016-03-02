package com.kevin.javabaselib.instance.designpattern.composite;
/**
 * @author 白良锦 bailiangjin@gmail.com
 *
 * @version 创建时间：2015年7月28日 上午11:37:01 
 *
 */
public class ProjectAssistant extends Employer {
    public ProjectAssistant(String name) {
        setName(name);
        employers = null;//项目助理, 表示没有下属了
    }
    public void add(Employer employer) {
        
    }
    public void delete(Employer employer) {
        
    }
}
