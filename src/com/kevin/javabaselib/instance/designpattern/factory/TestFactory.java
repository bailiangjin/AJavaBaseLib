package com.kevin.javabaselib.instance.designpattern.factory;


/**
 * @author 白良锦 bailiangjin@gmail.com
 *
 * @version 创建时间：2015年7月28日 上午10:38:11 
 *
 */
public class TestFactory {
    public static void main(String[] args) {
        IWorkFactory studentWorkFactory = new StudentWorkFactory();
        Work studentWork = studentWorkFactory.getWork();
        studentWork.doWork();

        IWorkFactory teacherWorkFactory = new TeacherWorkFactory();
        Work teatherWork = teacherWorkFactory.getWork();
	teatherWork.doWork();
    }
}

