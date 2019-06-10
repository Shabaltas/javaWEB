package by.training.task3.reader.matrix;

import by.training.task3.reader.FileException;
import by.training.task3.entity.matrix.Matrix;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

/**
 * Class that responsible for writing {@link Matrix}
 * in different output streams.
 */
public class MatrixWriter {
    /**
     * To log system information.
     */
    private static final Logger LOGGER = Logger.getLogger(MatrixReader.class);

    /**
     * Writes a {@code Matrix} in file.
     * @param matrix matrix to write
     * @param path path to file
     * @throws FileException
     *          if an I/O error occurs writing to or creating the file
     */
    public void writeInFile(Matrix matrix, Path path) throws FileException {
        try {
            Files.write(
                    path,
                    matrix.toString().getBytes(),
                    StandardOpenOption.TRUNCATE_EXISTING
            );
        } catch (IOException e) {
            LOGGER.warn(e);
            throw new FileException("Exception while writing matrix in file", e);
        }
    }
}
