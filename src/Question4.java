/*Try shutdown() and shutdownNow() and observe the difference.*/

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Question4 {
    public static void main(String[] args) {
        ExecutorService executorService= Executors.newFixedThreadPool(2);
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("This is Thread 1");
            }
        });
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("this is Thread 2");
            }
        });
        executorService.shutdownNow();
//        executorService.shutdown();
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("This is Thread 3");
            }
        });

    }
}

/*

output using shutdown :-

        This is Thread 1
        this is Thread 2
        Exception in thread "main" java.util.concurrent.RejectedExecutionException: Task java.util.concurrent.FutureTask@677327b6 rejected from java.util.concurrent.ThreadPoolExecutor@14ae5a5[Terminated, pool size = 1, active threads = 0, queued tasks = 0, completed tasks = 2]
        at java.util.concurrent.ThreadPoolExecutor$AbortPolicy.rejectedExecution(ThreadPoolExecutor.java:2063)
        at java.util.concurrent.ThreadPoolExecutor.reject(ThreadPoolExecutor.java:830)
        at java.util.concurrent.ThreadPoolExecutor.execute(ThreadPoolExecutor.java:1379)
        at java.util.concurrent.AbstractExecutorService.submit(AbstractExecutorService.java:112)
        at Question4.main(Question4.java:26)

output uding shutDownNow :-

This is Thread 1
this is Thread 2
java.lang.InterruptedException: sleep interrupted
	at java.lang.Thread.sleep(Native Method)
	at Question4$2.run(Question4.java:17)
	at java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:511)
	at java.util.concurrent.FutureTask.run(FutureTask.java:266)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1149)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624)
	at java.lang.Thread.run(Thread.java:748)
Exception in thread "main" java.util.concurrent.RejectedExecutionException: Task java.util.concurrent.FutureTask@677327b6 rejected from java.util.concurrent.ThreadPoolExecutor@14ae5a5[Terminated, pool size = 0, active threads = 0, queued tasks = 0, completed tasks = 2]
	at java.util.concurrent.ThreadPoolExecutor$AbortPolicy.rejectedExecution(ThreadPoolExecutor.java:2063)
	at java.util.concurrent.ThreadPoolExecutor.reject(ThreadPoolExecutor.java:830)
	at java.util.concurrent.ThreadPoolExecutor.execute(ThreadPoolExecutor.java:1379)
	at java.util.concurrent.AbstractExecutorService.submit(AbstractExecutorService.java:112)
	at Question4.main(Question4.java:26)



*/
