package task10ProducerConsumerWaitNotify;

public class Consumer extends Thread {
    Store store;
    Consumer(Store st){
        this.store = st;
    }

    @Override
    public void run() {
        for (int i = 1; i < 6; i++) {
            store.get();
        }
    }
}
