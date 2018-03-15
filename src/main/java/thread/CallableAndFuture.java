package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by darcy on 2018/2/1.
 */
public class CallableAndFuture {

    /**
     * 获取future的方法：
     * 1、submit()
     * 2、invokeAll()或者invokeAny()
     * 3、FutureTask实例，FutureTask可将Callable转化为Runnable或者Future
     * @param args
     */
    public static void main(String[] args) {
        Thread thread1 = new Thread(new Task1());
        thread1.start();

        FutureTask<Integer> futureTask = new FutureTask<>(new Task2());
        Thread thread2 = new Thread(futureTask);
        thread2.start();

        try {
            Integer result = futureTask.get();
            System.out.println(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }


}

class Task1 implements Runnable{

    @Override
    public void run() {
        System.out.println("i am task1");
    }
}

class Task2 implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        System.out.println("i am task2");
        return 1 ;
    }
}
