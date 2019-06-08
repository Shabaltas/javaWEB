package by.training.task3.reader.matrix;

import by.training.task3.parser.matrix.MatrixParser;
import by.training.task3.reader.FileException;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MatrixReader {
    private static final Logger LOGGER = Logger.getLogger(MatrixReader.class);
    private List<String> readRowsFromFile (Path path) throws FileException {
        try {
            return Files.readAllLines(path, Charset.forName("UTF-8"));
        } catch (IOException e) {
            LOGGER.warn(e);
            throw new FileException("Exception while reading matrix from file", e);
        }
    }
    public List<List<String>> readFromFile (Path path, int size) throws FileException {
        List<String> rows = readRowsFromFile(path);
        List<List<String>> result = new ArrayList<>(size);
        MatrixParser parser = new MatrixParser();
        rows.forEach(row -> result.add(parser.parseRow(row)));
        return result;
    }

}
