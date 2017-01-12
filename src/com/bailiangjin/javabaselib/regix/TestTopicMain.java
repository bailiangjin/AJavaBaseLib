package com.bailiangjin.javabaselib.regix;

import java.util.Map;

/**
 * Created by bailiangjin on 2016/12/6.
 */

public class TestTopicMain {

    static String content = "#每日病例分享$278$ ##小火每日一话$168$ #";


    public static void main(String[] args) {
        Map<String, String> topicMap = RichTextUtils.getTopicMap(content);
        if(null!=topicMap){

            for (Map.Entry<String, String> entry : topicMap.entrySet()) {
                System.out.println("" + entry.getKey() + "=" + entry.getValue());

            }

        }else {

            System.out.println("map is null");
        }



    }
}
