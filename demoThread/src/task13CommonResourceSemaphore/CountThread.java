package task13CommonResourceSemaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class CountThread implements Runnable {
    CommonResource resource;
    Semaphore semophore;
    String name;

    CountThread(CommonResource res, Semaphore sem, String str) {
        resource = res;
        semophore = sem;
        name = str;
    }

    @Override
    public void run() {
        try {
            System.out.println(name + " is waiting...");
            semophore.acquire();
            resource.x = 1;
            for (int i = 1; i < 5; i++) {
                System.out.println(name + ": " + resource.x);
                resource.x++;
              //  TimeUnit.MILLISECONDS.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name  + " releasing...");
        semophore.release();
    }
}
