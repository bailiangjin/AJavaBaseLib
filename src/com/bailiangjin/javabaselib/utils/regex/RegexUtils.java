package com.bailiangjin.javabaselib.utils.regex;

import com.bailiangjin.javabaselib.utils.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by bailiangjin on 16/7/21.
 */
public class RegexUtils {

    public static void main(String args[]) {
        String str = "白";
        boolean isMatch = isChinese(str);
        System.out.println(isMatch);
    }

    /**
     * 匹配单个字符 是否为中文
     *
     * @param str
     * @return
     */
    private static boolean isChinese(String str) {
        if (StringUtils.isEmpty(str)) {
            System.out.println("error: string param is null or empty");
            return false;
        }
        String patternStr = MacherPatternString.CN_STRING;
        Matcher matcher = isMatch(str, patternStr);
        return matcher.matches();
    }

    /**
     * 是否 符合要求
     *
     * @param str        字符串
     * @param patternStr 格式
     * @return
     */
    private static Matcher isMatch(String str, String patternStr) {
        Pattern pattern = Pattern.compile(patternStr);
        return pattern.matcher(str);
    }


}
