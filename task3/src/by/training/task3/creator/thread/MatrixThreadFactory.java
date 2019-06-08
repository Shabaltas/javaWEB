package by.training.task3.creator.thread;

import by.training.task3.entity.resource.CommonResource;
import by.training.task3.entity.resource.MatrixResource;
import by.training.task3.entity.thread.MatrixThread1;
import by.training.task3.parser.thread.ThreadParser;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class MatrixThreadFactory extends ThreadFactory {

    private static class LazyInitializer {
        private static final MatrixThreadFactory INSTANCE = new MatrixThreadFactory();
    }
    public static MatrixThreadFactory getInstance() {
        return LazyInitializer.INSTANCE;
    }
    private MatrixThreadFactory() { }
    @Override
    public MatrixThread1 createThread(CommonResource commonResource, ReentrantLock reentrantLoc, String line) {
        List<String> params  = new ThreadParser().parseLine(line);
        MatrixThread1 thread = new MatrixThread1((MatrixResource) commonResource, reentrantLoc, Integer.valueOf(params.get(1)));
        thread.setName(params.get(0));
        return thread;
    }
}
