package task11CommonResourceReentranLock;

import java.util.concurrent.locks.ReentrantLock;

public class Runner {
    public static void main(String[] args) {
        CommonResource resource = new CommonResource();
        ReentrantLock locker = new ReentrantLock();
        for (int i = 1; i < 6; i++) {
            Thread t = new Thread(new CountThread(resource, locker));
            t.setName("Thread " + i);
            t.start();
        }
    }
}
