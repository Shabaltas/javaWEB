package by.training.task3.creator.thread;

import by.training.task3.entity.resource.CommonResource;
import by.training.task3.entity.thread.LockThread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Abstract class-factory for creating {@link LockThread}.
 */
public abstract class LockThreadFactory {
    /**
     * Creates {@code LockThread} with {@code CommonResource},
     * {@code ReentrantLock} and parameters from {@code String}.
     * @param commonResource resource, that is sharing between threads
     * @param reentrantLock locker, thar responsible for locking the resources
     * @param line parameters
     * @return new {@code LockThread}
     */
    public abstract LockThread createThread(CommonResource commonResource,
                                            ReentrantLock reentrantLock,
                                            String line);
}
