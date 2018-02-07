package jvm;

/**
 * Created by darcy on 2018/2/6.
 */
public class VerifierTest {

    public static void main(String[] args) {
        System.out.println("1 + 2 == " + fun());
    }

    public static int fun(){
        int m;
        int n;
        m = 1;
        n = 2;
        int r = m + n;
        return r;
    }

}
