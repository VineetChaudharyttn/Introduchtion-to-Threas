/*Schedule task using schedule(), scheduleAtFixedRate() and scheduleAtFixedDelay()*/

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class Question7 {
    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

        Runnable task1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Scheduling 1: " + System.nanoTime());
            }
        };
        ScheduledFuture<?> future = executor.schedule(task1, 1, TimeUnit.SECONDS);
        long remainingDelay = future.getDelay(TimeUnit.MILLISECONDS);
        System.out.printf("Remaining Delay: %sms", remainingDelay);


        executor = Executors.newScheduledThreadPool(1);
        Runnable task2 =new Runnable() {
            @Override
            public void run() {
                System.out.println("Scheduling 2: " + System.nanoTime());
            }
        };
        int initialDelay = 0;
        int period = 1;
        executor.scheduleAtFixedRate(task2, initialDelay, period, TimeUnit.SECONDS);

        executor = Executors.newScheduledThreadPool(1);
        Runnable task3 =new Runnable() {
            @Override
            public void run() {
                System.out.println("Scheduling 3: " + System.nanoTime());
            }
        };
        int initialDelay1 = 5;
        int period1 = 1;
        executor.scheduleAtFixedRate(task3, initialDelay1, period1, TimeUnit.SECONDS);
    }
}
