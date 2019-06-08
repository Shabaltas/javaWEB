package by.training.task3.creator.thread;

import by.training.task3.entity.resource.CommonResource;

import java.util.concurrent.locks.ReentrantLock;

public abstract class ThreadFactory {
    public abstract Thread createThread(CommonResource commonResource, ReentrantLock reentrantLoc, String line);
}
