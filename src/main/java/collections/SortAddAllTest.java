package collections;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SortAddAllTest {

    //Arrays.asList 不能add
    public static void main(String[] args) {
        List<Integer> numList = Arrays.asList(5,3,2,6,0);
        List<Integer> numList2 = Arrays.asList(9,2);
        numList2.addAll(numList);
    }

    public void sort(List<Integer> integers){
        integers.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
    }

    public void printList(List<Integer> integers){
        for (Integer integer : integers) {
            System.out.println(integer);
        }
    }

}
