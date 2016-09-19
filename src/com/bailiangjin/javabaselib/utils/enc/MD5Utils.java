package com.bailiangjin.javabaselib.utils.enc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;

/**
 * Created by bailiangjin on 16/9/19.
 */
public class MD5Utils {

    public static String getFileMD5Str(String filePath) {
        FileInputStream fileInputStream = null;
        MessageDigest md = null;

        try {
            fileInputStream = openFile(filePath);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            System.out.println(e.getMessage());
        }

        return generateHashForFile(fileInputStream, md);
    }

    public static Boolean checksum(String filePath1, String filePath2) {

        String hash1 = getFileMD5Str(filePath1);
        String hash2 = getFileMD5Str(filePath2);

        System.out.println("======= MD5 Checksum =======");
        System.out.println("File 1: " + filePath1 + "\t| Checksum: " + hash1);
        System.out.println("File 2: " + filePath2 + "\t| Checksum: " + hash2);
        if (hash1.equals(hash2))
            System.out.println("These files are equals.");
        else
            System.out.println("These files are different.");

        return (hash1.equals(hash2));
    }

    private static String generateHashForFile(FileInputStream file, MessageDigest md) {
        DigestInputStream fileDigest = new DigestInputStream(file, md);

        try {
            while (fileDigest.read() != -1) ;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.exit(-1);
        }

        byte[] digested1 = md.digest();
        String hash = byteToHex(digested1);
        return hash;
    }


    private static FileInputStream openFile(String fileName) throws FileNotFoundException {
        return (new FileInputStream(fileName));
    }

    private static String byteToHex(byte[] bytes) {
        Formatter formatter = new Formatter();

        for (byte b : bytes) {
            formatter.format("%02x", b);
        }

        String hash = formatter.toString();
        formatter.close();
        return hash;
    }




//    public static void main(String[] args) {
//
//        String file1;
//        String file2;
//
//        if (args.length >= 2) {
//            file1 = args[0];
//            file2 = args[1];
//        } else {
//            file1 = "file.txt";
//            file2 = "file_3.txt";
//        }
//
//        Boolean isEquals = isSame(file1, file2);
//        System.out.println("Equals? " + isEquals);
//    }
//
//    private static Boolean isSame(String file1, String file2) {
//        return  MD5Utils.checksum(file1, file2);
//    }

}
