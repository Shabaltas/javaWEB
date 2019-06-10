package by.training.task3.creator.thread;

import by.training.task3.entity.resource.CommonResource;
import by.training.task3.entity.resource.MatrixResource;
import by.training.task3.entity.thread.MatrixThread;
import by.training.task3.parser.thread.ThreadParser;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Class-factory for creating {@link MatrixThread}.
 * Extends the {@link LockThreadFactory}.
 * Could be created only once by using
 * thread-safe Singleton's implementation.
 */
public final class MatrixThreadFactory extends LockThreadFactory {
    /**
     * The sequence number of the thread name in the parameter string.
     */
    private static final int NAME_NUMBER = 0;
    /**
     * The sequence number of the thread unique value in the parameter string.
     */
    private static final int VALUE_NUMBER = 1;
    /**
     * Nested class to create the only {@code MatrixThreadFactory}
     * as a static field only the first time this class is accessed.
     */
    private static class LazyInitializer {
        /**
         * The only instance of {@code MatrixThreadFactory}.
         */
        private static final MatrixThreadFactory INSTANCE = new MatrixThreadFactory();
    }

    /**
     * Returns the only instance of {@code MatrixThreadFactory}.
     * @return {@code LazyInitializer}'s static field
     */
    public static MatrixThreadFactory getInstance() {
        return LazyInitializer.INSTANCE;
    }

    /**
     * Private constructor to avoid
     * creating more than one {@code MatrixThreadFactory}.
     */
    private MatrixThreadFactory() { }

    /**
     * Creates new {@code MatrixThread}.
     * @param commonResource resource, that is sharing between threads
     * @param reentrantLock locker, thar responsible for locking the resources
     * @param line parameters
     * @return new {@code MatrixThread}
     */
    @Override
    public MatrixThread createThread(final CommonResource commonResource,
                                     final ReentrantLock reentrantLock,
                                     final String line) {
        List<String> params  = new ThreadParser().parseLine(line, " ");
        return new MatrixThread(
                params.get(NAME_NUMBER),
                (MatrixResource) commonResource,
                reentrantLock,
                Integer.valueOf(params.get(VALUE_NUMBER))
        );
    }
}
