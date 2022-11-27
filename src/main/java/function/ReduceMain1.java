package function;

import java.util.ArrayList;
import java.util.List;

public class ReduceMain1 {

    public static void main(String[] args) {
        List<Artist> list = new ArrayList<>();
        list.add(new Artist("zhc"));
        list.add(new Artist("xn"));
        String result = list.stream().map(Artist::getName).reduce("", (a, b) -> a + "," + b);
        result = result.replaceFirst(",", "[");
        result += "]";
        System.out.println(result);
    }


}
