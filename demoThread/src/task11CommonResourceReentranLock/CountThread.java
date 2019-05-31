package task11CommonResourceReentranLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class CountThread implements Runnable {
    CommonResource resource;
    ReentrantLock locker;
    CountThread(CommonResource res, ReentrantLock lock) {
        this.resource = res;
        this.locker = lock;
    }

    @Override
    public void run() {
        locker.lock();
        try {
            resource.x = 1;
            for (int i = 1; i < 5; i++) {
                System.out.printf("%s %d \n", Thread.currentThread().getName(), resource.x);
                resource.x++;
                TimeUnit.MILLISECONDS.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            locker.unlock();
        }
    }
}
