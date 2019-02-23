/*Use Synchronize block to enable synchronization between multiple threads trying to access method at same time*/

public class Question10 {

    int count=0;
    void counter(){
        synchronized (this){
            count++;
        }
    }


    public void worker1() {
        for (int i = 1; i <= 1000; i++) {
            counter();
        }
    }

    public void worker2() {
        for (int i = 1; i <= 1000; i++) {
            counter();
        }
    }
    public static void main(String[] args) throws InterruptedException {

        Question10 obj= new Question10();
        Thread th1=new Thread(new Runnable() {
            @Override
            public void run() {
                obj.worker1();
            }
        });
        Thread th2=new Thread(new Runnable() {
            @Override
            public void run() {
                obj.worker2();
            }
        });

        th1.start();
        th2.start();
        th1.join();
        th2.join();
        
        System.out.println("Count ="+obj.count);
    }
}
