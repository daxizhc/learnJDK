package function;

import java.util.ArrayList;
import java.util.List;

public class ReduceMain2 {

    public static void main(String[] args) {
        List<Artist> list = new ArrayList<>();
        list.add(new Artist("zhc"));
        list.add(new Artist("xn"));
        String result = list.parallelStream().map(Artist::getName)
                .reduce(new StringCombiner("[", "]", ","),
                StringCombiner::add, StringCombiner::merge).getResult();
        System.out.println(result);
    }


}
