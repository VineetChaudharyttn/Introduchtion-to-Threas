/*Increase concurrency with Thread pools using newCachedThreadPool() and newFixedThreadPool().*/
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Qusetion8 {

    public static void main(String[] args) {
        ExecutorService service= Executors.newFixedThreadPool(2);

//        ExecutorService service= Executors.newCachedThreadPool();
//
        service.submit(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<5;i++){
                    System.out.println("Runnable Thread 1");
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        service.submit(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<5;i++){
                    System.out.println("Runnable Thread 2");
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

}
