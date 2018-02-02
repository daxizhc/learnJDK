package thread;

import java.util.Date;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * Created by darcy on 2018/2/2.
 */
public class ForkAndJoin {

    public static void main(String[] args) {
        final Integer SIZE = 100000000;
        double numbers[] = new double[SIZE];
        for (int i = 0; i < SIZE; i++) {
            numbers[i] = Math.random();
        }

        Date time1 = new Date();
        Counter task = new Counter(numbers, 0, numbers.length - 1);
        new ForkJoinPool().invoke(task);
        System.out.println(task.join());
        Date time2 = new Date();
        System.out.println("多线程："+(time2.getTime() - time1.getTime()));

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Date time3 = new Date();
        int result = 0;
        for (int i = 0; i < SIZE; i++) {
            if (numbers[i] > 0.5)
                result++;
        }
        System.out.println(result);
        Date time4 = new Date();
        System.out.println("单线程："+(time4.getTime() - time3.getTime()));


    }

}

class Counter extends RecursiveTask<Integer> {
    public static final int THRESHOLD = 50000000;
    private int from;
    private int to;
    private double[] values;

    public Counter(double[] values, int from, int to) {
        this.to = to;
        this.values = values;
        this.from = from;
    }

    @Override
    protected Integer compute() {
        if (to - from < THRESHOLD) {
//            System.out.println("from : " + from + ", to : " + to);
            int result = 0;
            for (int i = from; i <= to; i++) {
                if (values[i] > 0.5) {
                    result++;
                }
            }
            return result;
        } else {
            int mid = (to + from) / 2;
            Counter fromCounter = new Counter(values, from, mid);
            Counter toCounter = new Counter(values, mid + 1, to);
            invokeAll(fromCounter, toCounter);
            return fromCounter.join() + toCounter.join();
        }
    }
}