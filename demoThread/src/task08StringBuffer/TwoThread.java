package task08StringBuffer;

import java.util.concurrent.TimeUnit;

public class TwoThread {
    public static int counter = 0;
    public static void main(String[] args){
        final StringBuilder s = new StringBuilder();
        new Thread(() -> {
            synchronized (s) {
                do {
                    s.append("A");
                    System.out.println(s);
                    try {
                        TimeUnit.MILLISECONDS.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } while (TwoThread.counter++ < 2);
            }
        }).start();
        new Thread(() -> {
            synchronized (s) {
                while (TwoThread.counter++ < 6) {
                    s.append("B");
                    System.out.println(s);
                }
            }
        }).start();
    }
}
