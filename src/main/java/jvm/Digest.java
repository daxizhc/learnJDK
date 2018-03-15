package jvm;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by darcy on 2018/2/7.
 */
public class Digest {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        String password = "123456";
        MessageDigest alg = MessageDigest.getInstance("MD5");
        byte[] input = password.getBytes();
        byte[] hash = alg.digest(input);
        String d = "";
        // 把hash用16进制表示
        for (int i = 0; i < hash.length; i++) {
            int v = hash[i] & 0xFF;
//            System.out.println(hash[i] + "\t" + v);
            if (v < 16)
                d += "0";
            d += Integer.toString(v, 16).toUpperCase();
        }
        System.out.println(d);
    }

}
