package effective.java;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
public class Chapter5 {

    public static void main(String[] args) {
        // 无限制通配符类型，只能传null
        Collection<?> collection = new ArrayList<>();
        collection.add(null);

        Set<Integer> integerSet = new HashSet<>();

        List<Integer> integerList = new ArrayList<>();
        Object[] objects = new Object[1];
        objects[0] = integerList;


    }

    // 应该改用List，不是很懂。。
    static <E> E reduce(List<E> list, Function<E> f, E initial){
        E[] snapshot = (E[])list.toArray();
        E result = initial;
        for (E e : snapshot) {
            result = f.apply(result, e);
        }
        return result;
    }

}

interface Function<T> {
    T apply(T arg1, T arg2);
}
