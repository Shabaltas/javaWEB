package by.training.task3.reader.matrix;

import by.training.task3.entity.matrix.Matrix;
import by.training.task3.parser.matrix.MatrixParser;
import by.training.task3.reader.FileException;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
/**
 * Class that responsible for reading data for creating {@link Matrix}.
 */
public class MatrixReader {
    /**
     * To log system information.
     */
    private static final Logger LOGGER = Logger.getLogger(MatrixReader.class);

    /**
     * Reads lines representing matrix rows from file.
     * @param path path to file
     * @param rows the number of matrix rows
     * @return {@code List} of rows
     * @throws FileException
     *          if an I/O error occurs reading from the file or a malformed or
     *          unmappable byte sequence is read
     */
    private List<String> readRowsFromFile(Path path, int rows) throws FileException {
        try {
            return Files.readAllLines(
                    path,
                    Charset.forName("UTF-8")
            ).subList(0, rows);
        } catch (IOException e) {
            LOGGER.warn(e);
            throw new FileException("Exception while reading matrix from file", e);
        }
    }

    /**
     * Reads lines representing matrix rows from file
     * and splits each row into the {@code List} of elements.
     * @param path path to file
     * @param rows the number of matrix rows
     * @param cols the number of matrix columns
     * @return a {@code List} where each element is a {@code List}
     *          of elements of the one row
     * @throws FileException
     *          if an I/O error occurs reading from the file or a malformed or
     *           unmappable byte sequence is read
     */
    public List<List<String>> readFromFile(Path path, int rows, int cols) throws FileException {
        List<String> lines = readRowsFromFile(path, rows);
        List<List<String>> result = new ArrayList<>(rows);
        MatrixParser parser = new MatrixParser();
        lines.forEach(line -> result.add(parser.parseRow(line, cols, " ")));
        return result;
    }

}
