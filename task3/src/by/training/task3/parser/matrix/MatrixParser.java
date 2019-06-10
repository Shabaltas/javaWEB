package by.training.task3.parser.matrix;

import by.training.task3.entity.matrix.Matrix;

import java.util.Arrays;
import java.util.List;

/**
 * Class that responsible for parsing a {@code String}
 * in the elements for creating {@link Matrix}.
 */
public class MatrixParser {
    /**
     * Parses a {@code String} consisting of one row's elements
     * divided by a splitter.
     * @param row row string representation
     * @param cols the number of columns
     * @param splitter splitter
     * @return {@code List} of strings, where each string is one element.
     */
    public List<String> parseRow(String row, int cols, String splitter) {
        return Arrays.asList(row.split(splitter)).subList(0, cols);
    }
}
