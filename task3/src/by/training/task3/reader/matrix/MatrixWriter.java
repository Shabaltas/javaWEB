package by.training.task3.reader.matrix;

import by.training.task3.reader.FileException;
import by.training.task3.entity.matrix.Matrix;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class MatrixWriter {
    private static final Logger LOGGER = Logger.getLogger(MatrixReader.class);
    public void writeInFile (Matrix matrix, Path path) throws FileException{
        try {
            Files.write(path, matrix.toString().getBytes(), StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            LOGGER.warn(e);
            throw new FileException("Exception while writing matrix in file", e);
        }
    }
}
