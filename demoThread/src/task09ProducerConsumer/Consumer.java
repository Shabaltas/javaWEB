package task09ProducerConsumer;

import java.util.concurrent.TimeUnit;

public class Consumer extends Thread {
    Store store;
    int product = 0;
    Consumer(Store st){
        this.store = st;
    }

    @Override
    public void run() {
        try {
            while (product < 5) {
                product = product + store.get();
                System.out.println("Consumer got " + product + " goods");
                TimeUnit.MILLISECONDS.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
