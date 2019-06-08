import matrix.Matrix;
import matrix.creator.MatrixCreator;
import matrix.writer.MatrixWriter;
import resource.CommonResource;
import resource.MatrixResource;
import thread.LockThread;
import thread.MatrixThread;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        int N = 12;
        Matrix matrix = new Matrix(N);
        try {
            new MatrixCreator().fillFromFile(matrix, Paths.get("data\\matrix"), N);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        CommonResource<Matrix> resource = new MatrixResource(matrix);
        ReentrantLock locker = new ReentrantLock();
        for (int i = 1; i < 7; i++) {
            LockThread thread = new MatrixThread(resource, locker, i);
            thread.start();
        }

        while (MatrixThread.getIndex() < N) {
            try {
                TimeUnit.MILLISECONDS.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //System.out.println(Thread.currentThread().getName() + ": now index = " + index);
        }
        try {
            new MatrixWriter().writeInFile(matrix, Paths.get("data\\result"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
