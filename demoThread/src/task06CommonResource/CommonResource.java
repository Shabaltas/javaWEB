package task06CommonResource;

import java.util.concurrent.TimeUnit;

public class CommonResource {
    int x = 0;


   // synchronized void increment(){
    void increment(){
        x = 1;
        for (int i = 1; i < 5; i++){
            System.out.printf("%s %d \n", Thread.currentThread().getName(), x);
            x++;
            try{
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
