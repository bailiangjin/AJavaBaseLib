package com.bailiangjin.javabaselib;

/**
 * Created by bailiangjin on 2017/1/15.
 */
public class Test {

    /**
     * @param args
     */
    public static void main(String[] args) {

        try {
            testAssert();
        }catch (AssertionError assertionError){
            System.out.println("assertError:"+assertionError.getMessage());
        }
    }


    public static void testAssert() throws AssertionError{
        int i = 0;
        for (i = 0; i < 5; i++) {
            System.out.println(i);
        }
        //假设程序不小心多了一句--i;

         --i;
        assert i == 5;

    }
}
