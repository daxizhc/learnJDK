package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by zhanghaochen on 2018/3/23.
 */
public class ArrayTest {

    public static void main(String[] args) {
        // 数组可以为null，但是调用length为NPE
        //        int[] test = null;
        //        System.out.println(test.length);

        //foreach 一个null，会报NPE ,在hibernate中，emptylist
//        List<Integer> list = Collections.EMPTY_LIST;;
//        for (Integer i: list) {
//            System.out.println(i);
//        }

        List<Integer> integers = Arrays.asList(1,2,3);
        integers = integers.stream().filter(integer -> integer==1).collect(Collectors.toList());
        integers.forEach(integer -> System.out.println(integer));

        integers = null;
        integers = new ArrayList<>();
        integers.forEach(integer -> System.out.println(integer));



    }



}
