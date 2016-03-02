package com.kevin.javabaselib.instance.designpattern.factory;


/**
 * @author 白良锦 bailiangjin@gmail.com
 *
 * @version 创建时间：2015年7月28日 上午10:38:50 
 *
 */
public class StudentWorkFactory implements IWorkFactory {
    public Work getWork() {
        return new StudentWork();
    }
}

