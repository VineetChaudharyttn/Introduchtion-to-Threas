/*Coordinate mulitple threads using wait() and notifyAll()*/
public class Question13 {
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

    public void worker3(){
        synchronized (this) {
            System.out.println("Worker 3 before wait");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Worker 3 after wait");
        }
    }

    public void worker4(){
        synchronized (this) {
            System.out.println("Worker 4 before wait");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Worker 4 after wait");
        }
    }

    public void worker2(){
        synchronized (this){
            System.out.println("worker 2 start");
            System.out.println("worker 2 before notify");
            notifyAll();
        }
    }

    public static void main(String[] args) {
        Question13 obj=new Question13();

        new Thread(new Runnable() {
            @Override
            public void run() {
                obj.worker1();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                obj.worker3();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                obj.worker4();
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
