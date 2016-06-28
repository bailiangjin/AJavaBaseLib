package com.kevin.javabaselib.utils.cmd;

import com.kevin.javabaselib.utils.FileUtils;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

/**
 * Created by bailiangjin on 16/6/26.
 */
public class CmdUtils {
    public CmdUtils() {
    }

    public static void main(String[] args) {
//        String cmd = "ping www.baidu.com";
        String cmd = "notepad";


        runCmd(cmd);
    }

    public static void runCmd(String cmd) {
        Runtime run = Runtime.getRuntime();

        try {
            Process process;
            String osName = System.getProperties().getProperty("os.name");
            System.out.println("osName:" + osName);
            if (null == osName) {
                return;
            }
            if (osName.toLowerCase().contains("mac")) {
                String[] e = new String[]{"/bin/sh", "-c", cmd};
                process = run.exec(e);
                String cmdBatFileName = "cmd.sh";
                FileUtils.saveStringToFile(cmdBatFileName, cmd, false);
            } else if (osName.toLowerCase().contains("windows")) {
                String signCmd = "@echo off\r\n" + cmd;
                String cmdBatFileName = "cmd.bat";
                FileUtils.saveStringToFile(cmdBatFileName, signCmd, false);
                File cmdBatFile = new File(cmdBatFileName);
                //String cmdForWindows = "cmd /c start " + cmdBatFile.getAbsolutePath();
                String cmdForWindows =  cmdBatFile.getAbsolutePath();
                process = run.exec(cmdForWindows);
            } else {
                return;
            }

            BufferedInputStream bufferedInputStream = new BufferedInputStream(process.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(bufferedInputStream));

            String lineStr;
            while ((lineStr = bufferedReader.readLine()) != null) {
                System.out.println(lineStr);
            }

            if (process.waitFor() != 0 && process.exitValue() == 1) {
                System.err.println("命令执行失败!");
            }

            bufferedReader.close();
            bufferedInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
