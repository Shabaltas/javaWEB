package by.training.task3.entity.thread;

import by.training.task3.entity.matrix.Matrix;
import org.apache.log4j.Logger;
import by.training.task3.entity.resource.MatrixResource;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
/**
 * Thread that uses {@link ReentrantLock} to
 * synchronize the access to {@link MatrixResource}.
 */
public class MatrixThread extends LockThread {
    /**
     * To log system information.
     */
    private final Logger logger = Logger.getLogger(this.getClass());

    /**
     * Constructor. Initializes all the fields.
     * @param name the name of the thread
     * @param commonResource shared resource
     * @param reentrantLocker locker
     * @param value unique value
     */
    public MatrixThread(final String name,
                        final MatrixResource commonResource,
                        final ReentrantLock reentrantLocker,
                        int value) {
        super(name, commonResource, reentrantLocker, value);
    }
    /**
     * Run the thread and change the elements
     * on the main diagonal of the {@code Matrix}
     * from {@code MatrixResource} by using {@code currIndex}
     * and changing it by decrementing to prevent multiple reassignment
     * from different threads.
     */
    @Override
    public void run() {
        Matrix matrix = (Matrix) resource.getValue();
        while (((MatrixResource) resource).getCurrIndex() > -1) {
            locker.lock();
            int i = ((MatrixResource) resource).getCurrIndex();
            if (i > -1) {
                logger.debug("index = "
                             + i
                             + " TIME: "
                             + System.currentTimeMillis());
                matrix.setElement(i, i, uniqValue);
                ((MatrixResource) resource).setCurrIndex(--i);
            }
            locker.unlock();
            try {
                TimeUnit.MILLISECONDS.sleep((long) (Math.random() * 50));
            } catch (InterruptedException e) {
                logger.warn(e);
                Thread.currentThread().interrupt();
            }
        }
    }
}
