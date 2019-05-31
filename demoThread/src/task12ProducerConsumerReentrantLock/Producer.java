package task12ProducerConsumerReentrantLock;

public class Producer implements Runnable {
    Store store;
    Producer(Store st){
        this.store = st;
    }

    @Override
    public void run() {
        for (int i = 1; i < 6; i++) {
            store.put();
        }
    }
}
