package io;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionTest {

    public static void main(String[] args) {
        String input = "abcdefghijklmnopqrstuvwxyz";
        Pattern pattern = Pattern.compile("[a-z]*");
        Matcher matcher = pattern.matcher(input);
        if(matcher.matches()){
            System.out.println(true);
        }
    }

}
