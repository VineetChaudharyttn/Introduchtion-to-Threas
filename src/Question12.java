/*Coordinate 2 threads using wait() and notify().*/


public class Question12 {

    public void worker1(){
        synchronized (this){
            System.out.println("worker 1 before wait");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("worker 1 after wait");
        }
    }

    public void worker2(){
        synchronized (this){
            System.out.println("worker 2 start");
            System.out.println("worker 2 before notify");
            notify();
        }
    }

    public static void main(String[] args) {
        Question12 obj=new Question12();

        new Thread(new Runnable() {
            @Override
            public void run() {
                obj.worker1();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                obj.worker2();
            }
        }).start();
    }
}
