package by.training.task3.runner;

import by.training.task3.creator.thread.MatrixThreadFactory;
import by.training.task3.reader.FileException;
import by.training.task3.entity.matrix.Matrix;
import by.training.task3.creator.matrix.MatrixCreator;
import by.training.task3.reader.matrix.MatrixWriter;
import by.training.task3.reader.thread.ThreadReader;
import org.apache.log4j.Logger;
import by.training.task3.entity.resource.MatrixResource;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Utility class to run the project.
 */
public class Runner {
    /**
     * Private constructor of utility class.
     */
    private Runner() { }

    /**
     * To log system information.
     */
    private static final Logger LOGGER = Logger.getLogger(Runner.class);

    /**
     * Runs the project(the main thread).
     * @param args arguments from console(not necessary)
     */
    public static void main(String[] args) {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("property.init");
        int matrixSize = Integer.parseInt(resourceBundle.getString("matrix_size"));
        int threadsCount = Integer.parseInt(resourceBundle.getString("threads_count"));

        Matrix matrix = new Matrix(matrixSize);
        List<String> values;
        try {
            new MatrixCreator().fillFromFile(
                    matrix,
                    Paths.get(resourceBundle.getString("matrix_input_file"))
            );
            values = new ThreadReader().readFromFile(
                    Paths.get(resourceBundle.getString("threads_input_file")),
                    threadsCount
            );

        } catch (FileException e) {
            LOGGER.warn(e);
            throw new RuntimeException(e);
        }
        MatrixResource resource = new MatrixResource(matrix);
        ReentrantLock locker = new ReentrantLock();
        MatrixThreadFactory threadFactory = MatrixThreadFactory.getInstance();
        for (int i = 0; i < threadsCount; i++) {
            threadFactory
                    .createThread(resource, locker, values.get(i))
                    .start();
        }

        while (resource.getCurrIndex() > -1) {
            try {
                TimeUnit.MILLISECONDS.sleep(20);
            } catch (InterruptedException e) {
                LOGGER.warn(e);
                Thread.currentThread().interrupt();
            }
        }
        try {
            new MatrixWriter().writeInFile(
                    matrix,
                    Paths.get(resourceBundle.getString("matrix_output_file"))
            );
        } catch (IOException e) {
            LOGGER.warn(e);
        }
    }
}
