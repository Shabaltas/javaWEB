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
        System.out.printf("Thread %s started...time: %d\n", Thread.currentThread().getName(), System.currentTimeMillis());
        int counter = 1;
        while (isActive){
            System.out.println("Disable cycle: " + counter++ + " time: " + System.currentTimeMillis());
            try{
                TimeUnit.MILLISECONDS.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.printf("Thread %s ended...time: %d\n", Thread.currentThread().getName(), System.currentTimeMillis());
    }
}
