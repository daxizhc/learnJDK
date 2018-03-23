package Collections;

/**
 * Created by zhanghaochen on 2018/3/23.
 */
public class ArrayTest {

    public static void main(String[] args) {
        int[] test = null;
        // 数组可以为null，但是调用length为NPE
        System.out.println(test.length);
    }

}
