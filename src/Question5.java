/*Use isShutDown() and isTerminate() with ExecutorService.*/

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Question5 {
    public static void main(String[] args) {
        ExecutorService executorService= Executors.newFixedThreadPool(2);
        try {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Thread 1 is running");
                }
            });
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Thread 2 is running");
                }
            });
//        executorService.shutdownNow();
            executorService.shutdown();
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Thread 3 is running");
                }
            });

        }
        catch (Exception e) {

        }
        finally {
            System.out.println(executorService.isShutdown());
            System.out.println(executorService.isTerminated());

        }
    }
}


/*
output:-
        Thread 1 is running
        true
        false
        Thread 2 is running
*/
