package string;

public class InternTest {
    public static void main(String[] args) {
        String s3 = new String("Hello" );
        s3.intern();
        String s4 = "Hello";
        System.out.println(s3 == s4);
        String s1 = new String("abc" ) + new String("def");
        s1.intern();
        String s2 = "abcdef";
        System.out.println(s1 == s2);
    }
}
