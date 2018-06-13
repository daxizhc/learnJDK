package regularexpression;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {

    // ((1?[0-9]):([0-5][0-9]))[ap]m  11:59am
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
                if(g > 0 ){
                    for(int j = 0; j < input.length(); j++){
                        for(int i = 1; i <= g; i++){
                            if(matcher.start(i) == j && matcher.end(i) == j){
                                System.out.print("()");
                            }
                        }
                        for(int i = 1; i <= g; i++){
                            if(matcher.start(i) == j && matcher.end(i) != j){
                                System.out.print("(");
                            }
                        }
                        System.out.print(input.charAt(j));
                        for(int i = 1; i<= g; i++){
                            if(matcher.start(i) != j+1 && matcher.end(i) == j+1){
                                System.out.print(")");
                            }
                        }

                    }
                    System.out.println();
                }
            }else {
                System.out.println("No Match");
            }
        }
    }

}
