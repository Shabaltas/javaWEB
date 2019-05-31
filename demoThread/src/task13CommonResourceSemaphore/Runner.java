package task13CommonResourceSemaphore;

import java.util.concurrent.Semaphore;

public class Runner {
    public static void main(String[] args) {
        Semaphore sem = new Semaphore(1);
        CommonResource res = new CommonResource();
        new Thread(new CountThread(res, sem, "CountThread1")).start();
        new Thread(new CountThread(res, sem, "CountThread2")).start();
        new Thread(new CountThread(res, sem, "CountThread3")).start();
    }
}
