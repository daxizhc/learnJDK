package regularexpression;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter pattern:");
        String patternString = in.nextLine();
        Pattern pattern = Pattern.compile(patternString);

        while (true){
            System.out.println("Enter string to match:");
            String input = in.nextLine();
            if(input == null || input.equals("")){
                return;
            }
            Matcher matcher = pattern.matcher(input);
            if(matcher.matches()){
                System.out.println("Match");
                int g = matcher.groupCount();




            }




        }



    }



}
