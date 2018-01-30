package thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by darcy on 2018/1/30.
 */
public class LockAndCondition {

    public static void main(String[] args) {

    }

    public class Bank{
        private final double[] account;
        private Lock lock;
        private Condition condition;

        public Bank(int n,double initialBalance) {
            account = new double[n];
            for (int i = 0; i < n; i++) {
                account[i] = initialBalance;
            }
            lock = new ReentrantLock();
            condition = lock.newCondition();
        }

        public void transfer(int from, int to, double amount) throws InterruptedException {
            lock.lock();
            try{
                while (account[from] < amount){
                    condition.await();
                }
                // do something
                condition.signalAll();
            }finally {
                lock.unlock();
            }

        }


    }

}
