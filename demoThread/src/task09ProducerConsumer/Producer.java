package task09ProducerConsumer;

import java.util.concurrent.TimeUnit;

public class Producer extends Thread {
    Store store;
    int product = 5;
    Producer(Store st){
        this.store = st;
    }

    @Override
    public void run() {
        try {
            while (product > 0) {
                product = product - store.put();
                System.out.println("Producer has " + product + " goods to produce");
                TimeUnit.MILLISECONDS.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
