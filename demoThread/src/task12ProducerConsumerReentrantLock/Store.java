package task12ProducerConsumerReentrantLock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Store {
    private int product = 0;
    ReentrantLock locker;
    Condition condition;
    Store() {
        locker = new ReentrantLock();
        condition = locker.newCondition();
    }
    public void get() {
        locker.lock();
        try {
            while (product < 1) {
                condition.await();
            }
            product--;
            System.out.println("Consumer got 1");
            System.out.println("Store has " + product);
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            locker.unlock();
        }
    }
    public void put() {
        locker.lock();
        try {
            while (product >= 3) {
                condition.await();
            }
            product++;
            System.out.println("Producer added 1");
            System.out.println("Store has " + product);
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            locker.unlock();
        }
    }
}
