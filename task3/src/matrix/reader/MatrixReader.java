package matrix.reader;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MatrixReader {
    private static String splitter = " ";
    public static void setSplitter(String newSplitter) {
        splitter = newSplitter;
    }
    private List<String> readRowsFromFile (Path path) throws IOException {
        return Files.readAllLines(path, Charset.forName("UTF-8"));
    }
    public List<List<String>> readFromFile (Path path, int size) throws IOException {
        List<String> rows = readRowsFromFile(path);
        List<List<String>> result = new ArrayList<>(size);
        rows.forEach(row -> result.add(Arrays.asList(row.split(splitter))));
        return result;
    }

}
