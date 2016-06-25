package com.kevin.javabaselib.utils.cmd;

/**
 * 命令行工具类
 * Created by bailiangjin on 16/6/24.
 */

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CmdUtils {
    public static void main(String[] args) {
//        /windows
//		String cmd = "F:\\apache-tomcat-6.0.20.exe";
//		String cmd = "D:\\Program Files\\Microsoft Office\\OFFICE11\\WINWORD.EXE F:\\test.doc";
//		String cmd = "cmd.exe /c start F:\\test.doc";
        String cmd = "ping www.baidu.com";
//
        //linux
//		String cmd = "./fork_wait";
//		String cmd = "ls -l";
//		String[] cmd=new String[3];
//		cmd[0]="/bin/sh";
//		cmd[1]="-c";
//		cmd[2]="ls -l ./";
        runCmd(cmd);
    }


    public static void runCmd(String cmd) {
        Runtime run = Runtime.getRuntime();//返回与当前 Java 应用程序相关的运行时对象
        try {
            String[] cmdArray = new String[]{"/bin/sh","-c",cmd};
            Process process = run.exec(cmdArray);// 启动另一个进程来执行命令
            BufferedInputStream bufferedInputStream = new BufferedInputStream(process.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(bufferedInputStream));
            String lineStr;
            while ((lineStr = bufferedReader.readLine()) != null)
                //获得命令执行后在控制台的输出信息
                System.out.println(lineStr);// 打印输出信息
            //检查命令是否执行失败。
            if (process.waitFor() != 0) {
                if (process.exitValue() == 1)//p.exitValue()==0表示正常结束，1：非正常结束
                    System.err.println("命令执行失败!");
            }
            bufferedReader.close();
            bufferedInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

