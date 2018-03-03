package innerclass;

import java.util.ArrayList;
import java.util.List;

public class AnonymousInnerClassTest {

    public static void main(String[] args) {
        List<String> people = new ArrayList<String>(){
            {
                add("sam");
                add("mary");
            }
        };
        people.forEach(person -> System.out.println(person));
    }

}
