package by.training.task3.parser.matrix;

import java.util.Arrays;
import java.util.List;

public class MatrixParser {
    private static String splitter = " ";
    public static void setSplitter(String newSplitter) {
        splitter = newSplitter;
    }
    public List<String> parseRow(String row) {
        return Arrays.asList(row.split(splitter));
    }
}
