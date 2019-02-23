/*Return a Future from ExecutorService by using callable and use get(), isDone(), isCancelled()
 with the Future object to know the status of task submitted.*/

import java.util.concurrent.*;

public class Question6 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService= Executors.newSingleThreadExecutor();

        Future<Integer> ref=executorService.submit(new Callable<Integer>(){

            @Override
            public Integer call() throws Exception {
                System.out.println("Thread 1 is running");
                return 2;
            }
        });

        executorService.shutdownNow();
        
        if (ref.isDone()) {
           System.out.println(ref.get());
        }
        if (ref.isCancelled())
            System.out.println("Your task has been cancelled");
    }
}
