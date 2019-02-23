/*Use sleep and join methods with thread.*/
public class Question2 {
    public static void main(String[] args) throws InterruptedException {
        Thread th= new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread");
            }
        });
        Thread th1= new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread 1");
            }
        });

        th.start();
        th.join();
        th1.start();
//        th1.join();
    }
}
