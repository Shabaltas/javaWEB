package task08StringBuffer;

import java.util.concurrent.TimeUnit;

public class BufferThread {
    static int counter = 0;
    static StringBuffer s =  new StringBuffer();
    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            synchronized (s) {
                while (BufferThread.counter++ < 3) {
                    s.append("A");
                    System.out.println("> " + counter + " ");
                    System.out.println(s);
                    try {
                        TimeUnit.MILLISECONDS.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        TimeUnit.MILLISECONDS.sleep(100);
        while (BufferThread.counter++ < 6) {
            System.out.println("< " + counter + " ");
            s.append("B");
            System.out.println(s);
        }
    }
}
