package thread;

import matrix.Matrix;
import resource.CommonResource;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class MatrixThread extends LockThread {
    private static int index = 0;

    public MatrixThread(CommonResource<Matrix> commonResource, ReentrantLock reentrantLocker, int value) {
        super(commonResource, reentrantLocker, value);
    }

    public static int getIndex() {
        return index;
    }

    @Override
    public void run() {
        locker.lock();
        Matrix matrix = (Matrix)resource.getValue();
        changeMatrix(matrix);
        locker.unlock();
        try {
            TimeUnit.MILLISECONDS.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        locker.lock();
        changeMatrix(matrix);
        locker.unlock();
    }

    private void changeMatrix(Matrix matrix) {
        if (index < matrix.getNumberOfRows()) {
            matrix.setElement(index, index, uniqValue);
            index++;
            System.out.println(Thread.currentThread().getName() + ": now index = " + index + " TIME: " + System.currentTimeMillis());
        }
    }
}
