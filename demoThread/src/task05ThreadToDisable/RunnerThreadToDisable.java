package task05ThreadToDisable;

import java.util.concurrent.TimeUnit;

public class RunnerThreadToDisable {

    public static void main(String[] args){

        System.out.println("Main thread started...time: " + System.currentTimeMillis());
        ThreadToDisable myThreadRunnable = new ThreadToDisable();
        Thread myT = new Thread(myThreadRunnable, "ThreadToDisable");
        InterruptedThread iT = new InterruptedThread("Interrupted");
        iT.start();
        myT.start();
        try{
            TimeUnit.MILLISECONDS.sleep(100);
            myThreadRunnable.disable();
            iT.interrupt();
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Main thread ended...time: " + System.currentTimeMillis());
    }
}
