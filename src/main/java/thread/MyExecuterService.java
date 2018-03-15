package thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by darcy on 2018/2/1.
 */
public class MyExecuterService {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        List<Callable<Integer>> callables = new ArrayList<>();

        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 0; i < 5 ; i++) {
            integers.add(i);
        }
        // 直接用i不行
        for (final Integer i : integers) {
            callables.add(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    System.out.println("callable "+i);
//                    if(1==1){
//                        throw new Exception();
//                    }
                    return i;
                }
            });
        }

        try {
            Integer result = executorService.invokeAny(callables);
            System.out.println(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}
