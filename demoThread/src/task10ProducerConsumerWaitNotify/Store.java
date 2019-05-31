package task10ProducerConsumerWaitNotify;

public class Store {
    private int product = 0;
    public synchronized void put() {
        while (product >= 3) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        product++;
        System.out.println("Producer added 1 of goods");
        System.out.println("Store has " + product + " goods");
        notify();
    }
    public synchronized void get() {
        while (product < 1) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        product--;
        System.out.println("Consumer got 1 of goods");
        System.out.println("Store has " + product + " goods");
        notify();
    }
}
