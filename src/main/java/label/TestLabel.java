package label;

/**
 * Created by zhanghaochen on 2018/3/19.
 */
public class TestLabel {

    public static void main(String[] args) {
        test_break:
        for (int i = 0; i < 5; i++) {
            System.out.print( "i = "+i+"\t");
            for (int j = 0; j < 5; j++) {
                System.out.print( "j = "+j+"\t");
                if(j==3) break test_break;
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("------------");

        test_continue:
        for (int i = 0; i < 5; i++) {
            System.out.print( "i = "+i+"\t");
            for (int j = 0; j < 5; j++) {
                if(j>=2)continue test_continue;
                System.out.print( "j = "+j+"\t");
            }
            System.out.println();
        }
    }


}
