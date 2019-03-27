package com.bailiangjin.javabaselib;

public class TestMain {
//    /**
//     * @param args
//     */
//    public static void main(String[] args) {
//
//        String osName = System.getProperties().getProperty("os.name");
//        if(osName.toLowerCase().contains("mac")){
//
//        }
//
//        System.out.println(osName);
//        // String gmail = "3b32cdfe@sin1a0000000.com.com.cm";
//        //
//        // System.out.println(isEmailFormat(gmail));
//        // String number = "010-20332058-0000";
//        // System.out.println(FormatCheckUtils.checkPhoneNumberValid(number));
//        // String mobile = "11630016890";
//        // System.out.println(ValidateUtils.checkMobileNumberValid(mobile));
//        // regextest();
//
////		GsonTestDemo.testGson();
////        Date date = DateUtils.getDateFromEnString("2016-4-12 21:12:00");
////
////        System.out.println("date:" + date.getTime());
////        System.out.println("date:" + DateUtils.getLongCurrentDate());
////        long sum = 0;
////        long fac = 1;
////        for (int i = 1; i <= 20; i++) {
////            fac = fac * i;
////            System.out.println(fac);
////            sum += fac;
////        }
////        System.out.println(sum);
//
//        String str= "初始值";
//
//        testChangeStr(str);
//
//        System.out.println(str);
//
//    }


    public static void testChangeStr(String str) {
        str = "已改变";

    }

    public static void main(String[] args) {
        int  step= countWays(50);
        System.out.print("次数="+step);
    }



    public static int countWays(int n) {
        if(n==0 || n==1 || n==2) {
            return n;
        }

        return countWays(n-1)+ countWays(n-2);
    }
}
