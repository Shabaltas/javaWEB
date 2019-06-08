package by.training.task3.entity.thread;

import by.training.task3.entity.resource.CommonResource;

import java.util.concurrent.locks.ReentrantLock;

public abstract class LockThread extends Thread {
    ReentrantLock locker;
    CommonResource resource;
    int uniqValue;
    LockThread (CommonResource commonResource, ReentrantLock reentrantLocker, int value) {
        super();
        resource = commonResource;
        locker = reentrantLocker;
        uniqValue = value;
    }

    public int getUniqValue() {
        return uniqValue;
    }
}
