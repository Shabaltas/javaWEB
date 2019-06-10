package by.training.task3.entity.thread;

import by.training.task3.entity.resource.CommonResource;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Thread that uses {@link ReentrantLock} to
 * synchronize the access to {@link CommonResource}.
 */
public abstract class LockThread extends Thread {
    /**
     * Used to access the resource.
     */
    ReentrantLock locker;
    /**
     * Shared resource.
     */
    CommonResource resource;
    /**
     * Unique value of this thread.
     */
    int uniqValue;

    /**
     * Constructor. Initializes all the fields.
     * @param name the name of the thread
     * @param commonResource shared resource
     * @param reentrantLocker locker
     * @param value unique value
     */
    LockThread(final String name,
               final CommonResource commonResource,
               final ReentrantLock reentrantLocker,
               final int value) {
        super(name);
        resource = commonResource;
        locker = reentrantLocker;
        uniqValue = value;
    }

    /**
     * Returns a unique value.
     * @return a unique value
     */
    public int getUniqValue() {
        return uniqValue;
    }
}
