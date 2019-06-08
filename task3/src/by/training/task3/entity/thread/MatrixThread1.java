package by.training.task3.entity.thread;

import by.training.task3.entity.matrix.Matrix;
import org.apache.log4j.Logger;
import by.training.task3.entity.resource.MatrixResource;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class MatrixThread1 extends LockThread {

    private final Logger logger = Logger.getLogger(this.getClass());

    public MatrixThread1(MatrixResource commonResource, ReentrantLock reentrantLocker, int value) {
        super(commonResource, reentrantLocker, value);
    }

    @Override
    public void run() {
        while (((MatrixResource) resource).getIndex() > -1) {
            locker.lock();
            int i = ((MatrixResource) resource).getIndex();
            Matrix matrix = (Matrix) resource.getValue();
            if (i > -1) {
                logger.debug("index = " + i + " TIME: " + System.currentTimeMillis());
                matrix.setElement(i, i, uniqValue);
                ((MatrixResource) resource).setIndex(--i);
            }
            locker.unlock();
            try {
                TimeUnit.MILLISECONDS.sleep((long)(Math.random()*50));
            } catch (InterruptedException e) {
                logger.warn(e);
                Thread.currentThread().interrupt();
            }
        }
    }
}
