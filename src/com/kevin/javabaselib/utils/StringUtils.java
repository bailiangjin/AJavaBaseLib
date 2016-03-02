/**
 *
 */
package com.kevin.javabaselib.utils;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * @author yubaojian0616@163.com
 *         <p>
 *         mobile enterprise application platform Version 0.1
 *         <p>
 *         <p>
 *         jiangneng 修改 增加较验的相关mobile enterprise application platform Version
 *         0.2
 *         <p>
 *         引用 pinyin4j jar 包
 */
public class StringUtils {

    public static String _HREF_URL_REGEX = "(http:|https:)//[^[A-Za-z0-9\\._\\?%&+\\-=/#!]]*";
    public static final String EMPTY_STRING = "";
    private static char chars[] = "0123456789abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ"
            .toCharArray();
    private static final char IntChars[] = "1234567890".toCharArray();

    public static boolean isEmpty(String str) {
        return null == str || str.length() == 0;
    }

    /**
     * 获得int
     *
     * @param val
     * @return
     */
    public static int getInt(String val) {
        return getInt(val, -1);
    }

    /**
     * 获得int
     *
     * @param val
     * @return
     */
    public static int getInt(Object val) {
        if (val == null)
            return -1;
        return getInt(val.toString(), -1);
    }

    /**
     * 获得int
     *
     * @param val
     * @param def
     * @return
     */
    public static int getInt(Object val, int def) {
        try {
            return Integer.parseInt(val.toString().trim());
        } catch (Exception e) {
            return def;
        }
    }

    /**
     * 获得long
     *
     * @param val
     * @return
     */
    public static long getLong(String val) {
        return getLong(val, -1);
    }

    /**
     * 获得long
     *
     * @param object
     * @return
     */
    public static long getLong(Object object) {
        return getLong(get(object.toString(), "-1"), -1);
    }

    /**
     * 获得long
     *
     * @param val
     * @param def
     * @return
     */
    public static long getLong(String val, long def) {
        try {
            return Long.parseLong(val.trim());
        } catch (Exception e) {
            return -1;
        }
    }

    /**
     * 获得boolean
     *
     * @param val
     * @return
     */
    public static boolean getBoolean(String val) {
        return getBoolean(val, false);
    }

    /**
     * 获得boolean
     *
     * @param val
     * @param def
     * @return
     */
    public static boolean getBoolean(String val, boolean def) {
        if (ValidateUtil.isNull(val))
            return def;
        try {
            return Boolean.parseBoolean(val);
        } catch (Exception e) {
            return def;
        }
    }

    /**
     * 获得double
     *
     * @param value
     * @return
     */
    public static double getDouble(String value) {
        return getDouble(value, 0.00);
    }

    /**
     * 获得double
     *
     * @param value
     * @param def
     * @return
     */
    public static double getDouble(String value, double def) {
        try {
            return Double.valueOf(value).doubleValue();
        } catch (Exception e) {
            return def;
        }
    }

    /**
     * 返回Trim后的字符串
     *
     * @param val
     * @return
     */
    public static String getTrim(String val) {
        val = getNonNull(val);
        return val.trim();
    }

    /**
     * 如果为null返回空字符串
     *
     * @param val
     * @return
     */
    public static String getNonNull(String val) {
        return get(val, EMPTY_STRING);
    }

    /**
     * 获得BigDecimal
     *
     * @param str
     * @return
     */
    public static BigDecimal getBigDecimal(String str) {
        try {
            BigDecimal bd = new BigDecimal(str);
            return bd;
        } catch (Exception e) {
            return BigDecimal.valueOf(-1.00);
        }
    }

    /**
     * 获得BigDecimal
     *
     * @param str
     * @return
     */
    public static BigDecimal getBigDecimal(String str, double def) {
        try {
            BigDecimal bd = new BigDecimal(str);
            return bd;
        } catch (Exception e) {
            return BigDecimal.valueOf(def);
        }
    }

    /**
     * yes/no转换成true/false
     *
     * @param aValue
     * @return
     */
    public static final String getBooleanFromYesNo(String aValue) {
        if (aValue.equalsIgnoreCase("yes")) {
            return "true";
        }

        return "false";
    }

    /**
     * 替换字符串
     *
     * @param text        原始文本
     * @param replaced    要替换内容
     * @param replacement 替换内容
     * @return
     */
    public static String replace(String text, String replaced, String replacement) {
        StringBuffer ret = new StringBuffer();
        String temp = text;

        while (temp.indexOf(replaced) > -1) {
            ret.append(temp.substring(0, temp.indexOf(replaced)) + replacement);

            temp = temp.substring(temp.indexOf(replaced) + replaced.length());
        }

        ret.append(temp);

        return ret.toString();
    }

    /**
     * 字符串替�?正反�?
     *
     * @param sIni
     * @param sFrom
     * @param sTo
     * @param caseSensitiveSearch
     * @return
     */
    public static String replaceString(String sIni, String sFrom, String sTo, boolean caseSensitiveSearch) {
        int i = 0;
        String s = new String(sIni);
        StringBuffer result = new StringBuffer();

        if (caseSensitiveSearch) {
            i = s.indexOf(sFrom);
        } else {
            i = s.toLowerCase().indexOf(sFrom.toLowerCase());
        }

        while (i != -1) {
            result.append(s.substring(0, i));
            result.append(sTo);

            s = s.substring(i + sFrom.length());

            if (caseSensitiveSearch) {
                i = s.indexOf(sFrom);
            } else {
                i = s.toLowerCase().indexOf(sFrom.toLowerCase());
            }
        }

        result.append(s);

        return result.toString();
    }

    /**
     * 将字符串转换成Vector通过Token
     *
     * @param sIn
     * @param sTokenizer
     * @return
     */
    public static List<String> tokenize(String sIn, String sTokenizer) {
        if (ValidateUtil.isNull(sIn))
            return new Vector<String>();
        Vector<String> vToken = new Vector<String>();
        int nOffset = 0;
        int nOffset1 = 0;

        nOffset1 = sIn.indexOf(sTokenizer, nOffset);

        while (nOffset1 > -1) {
            if (nOffset1 > nOffset) {
                vToken.add(sIn.substring(nOffset, nOffset1));
            } else {
                vToken.add(EMPTY_STRING);
            }

            nOffset = nOffset1 + sTokenizer.length();
            nOffset1 = sIn.indexOf(sTokenizer, nOffset);
        }

        if (nOffset < sIn.length()) {
            vToken.add(sIn.substring(nOffset, sIn.length()));
        } else {
            vToken.add(EMPTY_STRING);
        }

        return vToken;
    }

    /**
     * 将字符串转换成字符数组�?过token
     *
     * @param sIn
     * @param sTokenizer
     * @return
     */
    public static String[] tokenizeToArray(String sIn, String sTokenizer) {
        if (ValidateUtil.isNull(sIn)) {
            return new String[0];
        }
        List<String> vToken = tokenize(sIn, sTokenizer);
        String[] tokenArray = new String[vToken.size()];
        for (int i = 0; i < vToken.size(); i++) {
            tokenArray[i] = getTrim((String) vToken.get(i));
        }
        return tokenArray;
    }

    /**
     * 删除不能成为文件名的字符
     *
     * @param fileStr
     * @return
     */
    public static String removeIllegalFileChars(String fileStr) {
        String replacedFileStr = fileStr;

        replacedFileStr = replace(replacedFileStr, " ", "_");
        replacedFileStr = replace(replacedFileStr, "&", EMPTY_STRING);
        replacedFileStr = replace(replacedFileStr, "%", EMPTY_STRING);
        replacedFileStr = replace(replacedFileStr, ",", EMPTY_STRING);
        replacedFileStr = replace(replacedFileStr, ";", EMPTY_STRING);
        replacedFileStr = replace(replacedFileStr, "/", "_");

        return replacedFileStr;
    }

    /**
     * 获得字符串中的指点子字符�?
     *
     * @param strIn
     * @param start
     * @param length
     * @return
     */
    public static String substring(String strIn, int start, int length) {
        String strOut = null;

        if (strIn != null) {
            strOut = EMPTY_STRING;

            if (start < strIn.length() && length > 0) {
                if (start + length < strIn.length()) {
                    strOut = strIn.substring(start, start + length);
                } else {
                    strOut = strIn.substring(start, strIn.length());
                }
            }
        }

        return strOut;
    }

    /**
     * 随机生成length位数字字符串
     *
     * @param length
     * @return
     */
    public static final String getLengthRandomDigit(int length) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < length; i++) {
            str.append(IntChars[(int) (Math.random() * 10)]);
        }
        return str.toString();
    }

    /**
     * 随即生成length位字符串
     *
     * @param length
     * @return
     */
    public static final String getLengthRandomString(int length) {
        if (length < 1)
            return null;
        char ac[] = new char[length];
        for (int j = 0; j < ac.length; j++)
            ac[j] = chars[new Random().nextInt(71)];

        return new String(ac);
    }

    /**
     * 获得XML中的CDATA格式数据
     *
     * @param text
     * @return
     */
    public static String getCDATAData(String text) {
        if (!ValidateUtil.isNotNull(text))
            return EMPTY_STRING;
        return new StringBuffer().append("<![CDATA[").append(text).append("]]>").toString();
    }

    /**
     * 编码
     *
     * @param str     要编码的字符�?
     * @param charset 编码类型
     * @param ss      可�?,原来的类�?
     * @return
     */
    public static String encode(String str, String charset, String... ss) {
        if (ValidateUtil.isNull(str))
            return EMPTY_STRING;
        if (ValidateUtil.isNull(charset))
            return str;
        try {
            if (ss != null && ss.length > 0)
                return new String(str.getBytes(ss[0]), charset);
            else
                return new String(str.getBytes(), charset);
        } catch (UnsupportedEncodingException e) {
            return str;
        }
    }

    /**
     * 如果为null返回默认�?
     *
     * @param def
     * @return
     */
    public static String get(Object obj, String def) {
        if (obj == null)
            return def;
        return ValidateUtil.isNull(obj.toString()) ? def : obj.toString();
    }

    /**
     * 删除额外的空�?保证�?��空格
     *
     * @param str
     * @return
     */
    public static String removeExtraBlanks(String str) {
        if (ValidateUtil.isNull(str))
            return EMPTY_STRING;
        char[] chars = str.toCharArray();
        int finalIndex = 0;
        int spaceCount = 0;
        for (int i = 0; i < chars.length; ++i) {
            if (chars[i] != ' ') {
                chars[finalIndex] = chars[i];
                ++finalIndex;
                spaceCount = 0;
            } else if (chars[i] == ' ' && finalIndex == 0) {
            } else if (chars[i] == ' ' && spaceCount == 0) {
                chars[finalIndex] = chars[i];
                ++finalIndex;
                ++spaceCount;
            } else if (chars[i] == ' ' && spaceCount > 0) {
                ++spaceCount;
            }
        }
        for (int i = finalIndex; i < chars.length; ++i) {
            chars[i] = ' ';
        }
        return String.valueOf(chars);
    }

    /**
     * 删除�?��空格
     *
     * @param str
     * @return
     */
    public static String removeBlanks(String str) {
        if (str == null || str.equals(EMPTY_STRING))
            return str;
        char ac[] = str.toCharArray();
        char ac1[] = new char[ac.length];
        int i = 0;
        for (int j = 0; j < ac.length; j++)
            if (!Character.isSpaceChar(ac[j]))
                ac1[i++] = ac[j];

        return new String(ac1, 0, i);
    }

    /**
     * 二行制转字符�?
     *
     * @param b
     * @return
     */
    public static String byte2hex(byte[] b) {
        StringBuilder hs = new StringBuilder();
        String stmp = EMPTY_STRING;
        for (int n = 0; n < b.length; n++) {
            stmp = (java.lang.Integer.toHexString(b[n] & 0XFF));
            if (stmp.length() == 1)
                hs.append("0").append(stmp);
            else
                hs.append(stmp);
        }
        return hs.toString().toUpperCase();
    }

    /**
     * 获得List的字符串连接
     *
     * @param list
     * @return
     */
    public static String getStringFromList(List<String> list, String... split) {
        if (list == null) {
            return EMPTY_STRING;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0, j = list.size(); i < j; i++) {
            sb.append(list.get(i));
            if (split != null && split.length > 0)
                sb.append(split[0]);
        }
        return sb.toString();
    }

    /**
     * 连接对象
     *
     * @param objs
     * @return
     */
    public static String concat(Object... objs) {
        if (objs == null || objs.length < 1)
            return EMPTY_STRING;
        StringBuffer sb = new StringBuffer();
        for (Object obj : objs) {
            sb.append(obj == null ? EMPTY_STRING : obj.toString());
        }
        return sb.toString();
    }

    /**
     * 连接数组
     *
     * @param array
     * @param split
     * @return
     */
    public static String getStringFromArray(String[] array, String... split) {
        if (array == null)
            return EMPTY_STRING;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            if (i > 0 && split != null && ValidateUtil.isNotNull(split[0]))
                sb.append(split[0]);
            sb.append(array[i]);
        }
        return sb.toString();
    }

    /**
     * 连接list
     *
     * @param connector
     * @param list
     * @return
     */
    public static String concatList(String connector, List<?> list) {
        return concatArray(connector, list.toArray(new Object[list.size()]));
    }

    /**
     * 连接数组
     *
     * @return
     */
    public static <T> String concatArray(String connector, T... objects) {
        if (objects == null || objects.length < 1)
            return EMPTY_STRING;
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < objects.length; i++) {
            if (objects[i] == null || ValidateUtil.isNull(objects[i].toString()))
                continue;
            if (i > 0)
                sb.append(connector);
            sb.append(objects[i].toString());
        }
        return sb.toString();
    }

    /**
     * 自由组合列表
     *
     * @param list
     * @return
     */
    public static List<String> combined(List<List<String>> list) {
        if (list.size() == 1) {
            return list.get(0);
        } else if (list.size() == 2) {
            return combined(list.get(0), list.get(1));
        } else {
            List<String> tempList = new ArrayList<String>();
            for (int i = list.size(); i > 0; i--) {
                tempList = combined(list.get(i - 1), tempList);
            }
            return tempList;
        }
    }

    /**
     * 自由组合两列�?
     *
     * @param list1
     * @param list2
     * @return
     */
    public static List<String> combined(List<String> list1, List<String> list2) {
        if (list2.isEmpty())
            return list1;
        List<String> results = new ArrayList<String>();
        for (String str1 : list1) {
            for (String str2 : list2) {
                results.add(str1 + "," + str2);
            }
        }
        return results;
    }

    /**
     * 字符串替�?
     *
     * @param text  原字符串
     * @param terms Map类型 Key:要替换内�?value:替换后内�?
     * @return
     */
    public static String replaceAll(String text, Map<String, String> terms) {
        String textResult = text;
        for (String key : terms.keySet()) {
            if (ValidateUtil.isNotNull(key) && ValidateUtil.isNotNull(terms.get(key)))
                textResult = Pattern.compile(key).matcher(textResult).replaceAll(terms.get(key));
        }
        return textResult;
    }

    /**
     * 正则表达式替�?
     *
     * @param str         源字符串
     * @param pattern     要替换的模式
     * @param replacement 替换成的内容
     * @return
     */
    public static String regexReplace(String str, String pattern, String replacement) {
        if (ValidateUtil.isNull(str))
            return EMPTY_STRING;
        if (ValidateUtil.isNull(pattern))
            return str;
        return str.replaceAll(pattern, replacement);
    }

    /**
     * 正则替换
     *
     * @param str       源字符串
     * @param pattern   要替换的模式
     * @param replace   替换成的内容
     * @param connector 连接�?
     * @param def       默认�?
     * @return
     */
    public static String regex(String str, String pattern, String replace, String connector, String def) {
        if (str == null || pattern == null || connector == null)
            return null;
        Pattern p = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE);
        Matcher matcher = p.matcher(str);
        StringBuffer sb = new StringBuffer();
        int i = 0;
        for (i = 0; matcher.find(); i++) {
            if (i > 0)
                sb.append(connector);
            matcher.appendReplacement(sb, replace);
        }
        if (i > 0)
            matcher.appendTail(sb).append(def);
        else
            sb.append(str);
        return sb.toString();
    }

    /**
     * 查找符合正则的表达式的字符串
     *
     * @param str
     * @param pattern
     * @param index
     * @return
     */
    public static String regexFind(String str, String pattern, int index) {
        if (ValidateUtil.isNull(str))
            return EMPTY_STRING;
        Pattern p = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE);
        Matcher matcher = p.matcher(str);
        for (int i = 1; matcher.find(); i++) {
            if (i == index) {
                return matcher.group();
            }
        }
        return EMPTY_STRING;
    }

    /**
     * 将普通文本中的链接提取成超链�?
     *
     * @param text
     * @return
     */
    public static String getHrefText(String text) {
        try {
            Pattern pattern = Pattern.compile(_HREF_URL_REGEX);
            Matcher matcher = pattern.matcher(text);
            StringBuffer result = new StringBuffer();
            String url;
            while (matcher.find()) {
                url = matcher.group();
                StringBuffer replace = new StringBuffer();
                replace.append("<a href=\"").append(url);
                replace.append("\" target=\"_blank\">" + url + "</a>");
                matcher.appendReplacement(result, replace.toString());
            }
            matcher.appendTail(result);
            return get(result.toString(), text);
        } catch (Exception e) {
            return text;
        }
    }

    /**
     * 字符串解析Map
     *
     * @param text
     * @param termSplit
     * @param keySplit
     * @return
     */
    public static Map<String, String> getMap(String text, String termSplit, String keySplit) {
        Map<String, String> values = null;
        if (ValidateUtil.isNotNull(text)) {
            values = new LinkedHashMap<String, String>();
            for (String line : StringUtils.tokenize(text, termSplit)) {
                if (ValidateUtil.isNull(line))
                    continue;
                String[] t = line.split(keySplit);
                if (t.length == 1) {
                    values.put(StringUtils.getTrim(t[0]), StringUtils.getTrim(t[0]));
                    continue;
                }
                if (t.length != 2)
                    continue;
                values.put(t[0], StringUtils.getTrim(t[1]));
            }
        }
        return values == null ? new HashMap<String, String>() : values;
    }

    /**
     * 通过字节截断字符串长�?
     *
     * @param str
     * @param length
     * @param more
     * @return
     */
    public static String substringByByte(String str, int length, String more) {
        int reInt = 0;
        String reStr = EMPTY_STRING;
        if (ValidateUtil.isNull(str))
            return EMPTY_STRING;
        char[] tempChar = str.toCharArray();
        for (int kk = 0; (kk < tempChar.length && length > reInt); kk++) {
            String s1 = String.valueOf(tempChar[kk]);
            byte[] b = s1.getBytes();
            reInt += b.length;
            reStr += tempChar[kk];
        }
        if (length == reInt || (length == reInt - 1))
            reStr += more;
        return reStr;
    }

    /**
     * 获得指定小数�?
     *
     * @param value
     * @param fixed
     * @return
     */
    public static BigDecimal getFixedBigDecimal(String value, int fixed) {
        try {
            BigDecimal result = new BigDecimal(value);
            return result.setScale(fixed, BigDecimal.ROUND_HALF_UP);
        } catch (Exception e) {

        }
        return BigDecimal.ZERO;
    }

    /**
     * 获得正则匹配的字符串
     *
     * @param text
     * @param pattern
     * @param group
     * @return
     */
    public static String getMatcherGroup(String text, String pattern, int group) {
        if (ValidateUtil.isNotNull(text) && ValidateUtil.isNotNull(pattern)) {
            Pattern p = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE);
            Matcher matcher = p.matcher(text);
            if (matcher.matches()) {
                return matcher.group(group);
            }
        }
        return null;
    }

    /**
     * 判断字符是否是中文字�?
     *
     * @param c
     * @return
     */
    public static boolean isChinese(char c) {
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
        if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A
                || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION
                || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
                || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {
            return true;
        }
        return false;
    }

    /**
     * 判断字符串是否是中文字符�?
     *
     * @return
     */
    public static boolean isChinese(String word) {
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!isChinese(c)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 判断字符串是否包含中文字符
     *
     * @return
     */
    public static boolean containsChinese(String word) {
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (isChinese(c)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断字符是否是英文字�?
     *
     * @param c
     * @return
     */
    public static boolean isEnglish(char c) {
        if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')) {
            return true;
        }
        return false;
    }

    /**
     * 判断字符串是否为英文字符�?
     *
     * @param word
     * @return
     */
    public static boolean isEnglish(String word) {
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!isEnglish(c)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Description: 判断字符串是否为数字
     *
     * @param str String 字符�?
     * @return boolean 如果为数字则返回true,否则返回false
     */
    public static boolean isNumber(String str) {
        boolean flag = true;
        if (str != null && str.length() > 0) {
            int i = str.length();
            for (int j = 0; j < i && flag; j++) {
                if (!isNumber(str.charAt(j))) {
                    flag = false;
                }
            }
        }
        return flag;
    }

    /**
     * Description: 判断char是否为数�?
     *
     * @param c char 字节
     * @return boolean 如果为数字则返回true,否则返回false
     */
    public static boolean isNumber(char c) {
        boolean flag = false;
        if (c == '0' || c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7' || c == '8'
                || c == '9')
            flag = true;
        return flag;
    }

    /**
     * 在字符串后补0补足count�?
     *
     * @param str
     * @param count
     * @return
     */
    public static String fillAfterZero(String str, int count) {
        if (str == null) {
            return null;
        } else if (str.length() >= count) {
            return str;
        }
        String zeroStr = "";
        for (int i = 0; i < (count - str.length()); i++) {
            zeroStr += "0";
        }
        return str + zeroStr;
    }

//    /**
//     * 汉字转换位汉语拼音首字母，英文字符不变
//     *
//     * @param chines 汉字
//     * @return 拼音
//     */
//    public static String converterToFirstSpell(String chines) {
//        String pinyinName = "";
//        char[] nameChar = chines.toCharArray();
//        HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
//        defaultFormat.setCaseType(HanyuPinyinCaseType.UPPERCASE);
//        defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
//        // for (int i = 0; i < nameChar.length; i++) {
//        if (nameChar[0] > 128) {
//            try {
//                if (PinyinHelper.toHanyuPinyinStringArray(nameChar[0], defaultFormat) != null) {
//                    pinyinName = String.valueOf((PinyinHelper.toHanyuPinyinStringArray(nameChar[0], defaultFormat)[0]
//                            .charAt(0)));
//                } else {
//                    return "#";
//                }
//
//            } catch (Exception e) {
//                e.printStackTrace();
//                return "#";
//            }
//        } else {
//            if (nameChar[0] >= 97 && nameChar[0] <= 122) {
//                nameChar[0] = (char) (nameChar[0] - 32);
//            }
//            if (nameChar[0] < 'A' || nameChar[0] > 'Z') {
//                return "#";
//            } else {
//                return String.valueOf(nameChar[0]);
//            }
//        }
//        // }
//        return pinyinName;
//    }

}
