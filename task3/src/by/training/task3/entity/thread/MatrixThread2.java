package by.training.task3.entity.thread;

import by.training.task3.entity.matrix.Matrix;
import org.apache.log4j.Logger;
import by.training.task3.entity.resource.CommonResource;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class MatrixThread2 extends LockThread {
    private static int index = 0;
    private final Logger logger = Logger.getLogger(this.getClass());

    MatrixThread2(CommonResource commonResource, ReentrantLock reentrantLocker, int value) {
        super(commonResource, reentrantLocker, value);
    }

    public static int getIndex() {
        return index;
    }

    private void changeMatrix(Matrix matrix) {
        if (index < matrix.getNumberOfRows()) {
            matrix.setElement(index, index, uniqValue);
            index++;
            logger.debug("now index = " + index + " TIME: " + System.currentTimeMillis());
        }
    }

    @Override
    public void run() {
        locker.lock();
        Matrix matrix = (Matrix) resource.getValue();
        changeMatrix(matrix);
        locker.unlock();
        try {
            TimeUnit.MILLISECONDS.sleep(20);
        } catch (InterruptedException e) {
            logger.warn(e);
            Thread.currentThread().interrupt();
        }
        locker.lock();
        changeMatrix(matrix);
        locker.unlock();
    }
}
