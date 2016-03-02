package com.kevin.javabaselib.instance.designpattern.composite;

import java.util.ArrayList;

/**
 * @author 白良锦 bailiangjin@gmail.com
 *
 * @version 创建时间：2015年7月28日 上午11:37:30 
 *
 */
public class ProjectManager extends Employer {
    
    public ProjectManager(String name) {
        setName(name);
        employers = new ArrayList();
    }
    
    public void add(Employer employer) {
        employers.add(employer);
    }
    public void delete(Employer employer) {
        employers.remove(employer);
    }
}
