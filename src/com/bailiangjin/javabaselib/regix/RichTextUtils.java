package com.bailiangjin.javabaselib.regix;


import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Created by bailiangjin on 2016/12/5.
 */

public class RichTextUtils {

    /**
     * 服务器返回的带有id的话题整体匹配
     */
    public static final String TOPIC_REGEX = "#([^#]+?)\\$([0-9]+)\\$ #";

    /**
     * 话题id匹配
     */
    public static final String TOPIC = "\\$([0-9]+)\\$ ";


//    public static int TOPIC_COLOR = AppUtils.getAppContext().getResources().getColor(R.color.topic_label);

    public static Map<String, String> getTopicMap(String content) {

        Map<String, String> topicsMap = new HashMap<String,String>();

        Pattern fullPattern = Pattern.compile(TOPIC_REGEX);
        Matcher fullMatcher = fullPattern.matcher(content);

        while (fullMatcher.find()) {
            //带id的标签
            String fullLabel = fullMatcher.group();
            // 设置正则匹配所有话题的id，并取出保存
            Pattern idPattern = Pattern.compile(TOPIC);
            Matcher idMatcher = idPattern.matcher(fullLabel);
            while (idMatcher.find()) {
                String idStr = idMatcher.group();
                //去掉id的文本标签
                String textLabel = fullLabel.replaceAll(TOPIC, "");
                //话题Id
                String topicId = idStr.trim().replaceAll("\\$", "");
                topicsMap.put(textLabel, topicId);
                fullLabel = fullLabel.replace(fullLabel, textLabel);
            }
        }

        return topicsMap;

    }
}
