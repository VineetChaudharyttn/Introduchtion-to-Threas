/*Create and Run a Thread using Runnable Interface and Thread class*/
public class Question1 extends Thread {

    @Override
    public void run() {
        for(int i=0;i<5;i++){
            System.out.println("Thread");
        }
    }

    public static void main(String[] args) {
        Question1 th= new Question1();

        th.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<5;i++){
                    System.out.println("Runnable");
                }
            }
        }).start();
    }
}
