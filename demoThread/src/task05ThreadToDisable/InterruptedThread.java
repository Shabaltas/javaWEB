package task05ThreadToDisable;

import java.util.concurrent.TimeUnit;

public class InterruptedThread extends Thread {
    public InterruptedThread(String name){
        super(name);
    }

    public void run(){
        System.out.printf("Thread %s started... time: %d\n", Thread.currentThread().getName(), System.currentTimeMillis());
        int counter = 1;
        while (!isInterrupted()){
            System.out.println("Cycle: " + counter++ + " time: " + System.currentTimeMillis());
            int i = 0;
            try{
                TimeUnit.MILLISECONDS.sleep(20);
            } catch (InterruptedException e) {
                stop();
                e.printStackTrace();
            }
           // while (i++ < 10000) {}
        }
        System.out.printf("Thread %s ended...time: %d\n", Thread.currentThread().getName(), System.currentTimeMillis());
    }
}
