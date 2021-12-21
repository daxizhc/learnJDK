package thread;

import java.time.LocalDateTime;
import java.util.concurrent.CompletableFuture;

public class CompletableFutureTest {


    private static Runnable sleepOneSecond = () -> {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    };

    public static void main(String[] args) {
        LocalDateTime start = LocalDateTime.now();
        inSync();
        inAsync();
        LocalDateTime end = LocalDateTime.now();
        System.out.println(end.getSecond() - start.getSecond());

    }

    private static void inSync() {
        sleepOneSecond.run();
        sleepOneSecond.run();
        sleepOneSecond.run();
    }

    private static void inAsync() {
        CompletableFuture<Void> future1 = CompletableFuture.runAsync(sleepOneSecond);
        CompletableFuture<Void> future2 = CompletableFuture.runAsync(sleepOneSecond);
        CompletableFuture<Void> future3 = CompletableFuture.runAsync(sleepOneSecond);
        CompletableFuture.allOf(future1, future2, future3).join();
    }

}
