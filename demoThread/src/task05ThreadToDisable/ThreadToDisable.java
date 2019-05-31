package task05ThreadToDisable;

import java.util.concurrent.TimeUnit;

public class ThreadToDisable implements Runnable {

    private boolean isActive;

    void disable(){
        isActive = false;
    }

    ThreadToDisable(){
        isActive = true;
    }

    public void run(){
        System.out.printf("Thread %s started...\n", Thread.currentThread().getName());
        int counter = 1;
        while (isActive){
            System.out.println("Cycle: " + counter++);
            try{
                TimeUnit.MILLISECONDS.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.printf("Thread %s ended...\n", Thread.currentThread().getName());
    }
}
