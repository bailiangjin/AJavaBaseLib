package com.bailiangjin.javabaselib;

import com.bailiangjin.javabaselib.utils.date.DateGapUtils;
import com.bailiangjin.javabaselib.utils.date.DateTransformUtils;

import java.util.Date;

public class TestMain {
    /**
     * @param args
     */
    public static void main(String[] args) {

//        String osName = System.getProperties().getProperty("os.name");
//        if (osName.toLowerCase().contains("mac")) {
//
//        }
//
//        System.out.println(osName);
        // String gmail = "3b32cdfe@sin1a0000000.com.com.cm";
        //
        // System.out.println(isEmailFormat(gmail));
        // String number = "010-20332058-0000";
        // System.out.println(FormatCheckUtils.checkPhoneNumberValid(number));
        // String mobile = "11630016890";
        // System.out.println(ValidateUtils.checkMobileNumberValid(mobile));
        // regextest();

//		GsonTestDemo.testGson();
        Date date = DateTransformUtils.getDate("2017-05-27","yyyy-M-d");

        System.out.println("date:" + DateGapUtils.isTomorrow(date.getTime()));
        System.out.println("date:" + DateTransformUtils.getCurrentTimeMillis());
//        long sum = 0;
//        long fac = 1;
//        for (int i = 1; i <= 20; i++) {
//            fac = fac * i;
//            System.out.println(fac);
//            sum += fac;
//        }
//        System.out.println(sum);

        int i = 1;

        switch (i) {
            case 1:
                System.out.println("1");
            case 0:
                System.out.println("0");
                break;
            default:
                System.out.println("default");

        }
    }

}
