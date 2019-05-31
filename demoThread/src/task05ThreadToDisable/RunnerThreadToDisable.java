package task05ThreadToDisable;

import java.util.concurrent.TimeUnit;

public class RunnerThreadToDisable {

    public static void main(String[] args){

        System.out.println("Main thread started...\n");
        ThreadToDisable myThread = new ThreadToDisable();
        Thread myT = new Thread(myThread, "ThreadToDisable");
        myT.start();
        try{
            TimeUnit.MILLISECONDS.sleep(1100);
            myThread.disable();
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Main thread ended...\n");
    }
}
