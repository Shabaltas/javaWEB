package by.training.task3.creator.matrix;

import by.training.task3.reader.FileException;
import by.training.task3.entity.matrix.Matrix;
import by.training.task3.reader.matrix.MatrixReader;

import java.nio.file.Path;
import java.util.List;

/**
 * Matrix creator class.
 * <p>Consists of method to initialize {@link Matrix}.
 */
public class MatrixCreator {

    /**
     * Initializes the {@code Matrix} with data from file.
     * Calls a method {@link MatrixReader#readFromFile(Path, int, int)}
     * to read the data and than sets the all elements of the {@code Matrix}.
     * @param matrix {@code Matrix} to fill
     * @param path {@code Path} to the file
     * @throws FileException if an I/O error occurs reading from the stream
     */
    public void fillFromFile(Matrix matrix, Path path) throws FileException {
        int rows = matrix.getNumberOfRows();
        int cols = matrix.getNumberOfColumns();
        List<List<String>> stringMatrix = new MatrixReader()
                                            .readFromFile(path, rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix.setElement(i, j, Integer.parseInt(stringMatrix
                                                            .get(i)
                                                            .get(j)));
            }
        }
    }
}
